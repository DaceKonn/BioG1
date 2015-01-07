package BiomorphGenerate; /**
 * Created by harold on 27.04.14.
 */
import Exceptions.CustomException;
import Iterations.Iterate;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.util.FastMath;

import java.util.*;
import java.util.List;
import java.util.concurrent.*;

public class BiomorphGenerate
{
    private Biomorph biomorph;
    private Iterate method;
    private int size;
    private double threshold;
    private int iterations;
    private MyPoint point_a;
    private MyPoint point_b;
    private int magCheck = 1;

    private static final int NTHREDS = 1;

    public BiomorphGenerate()
    {
    }

    //<editor-fold desc="With Section">
    public BiomorphGenerate WithPointA(MyPoint pointA)
    {
        point_a = pointA;
        return this;
    }

    public BiomorphGenerate WithPointB(MyPoint pointB)
    {
        point_b = pointB;
        return this;
    }

    public BiomorphGenerate WithSize(int size)
    {
        this.size = size;
        return this;
    }

    public BiomorphGenerate WithIterations(int iterations)
    {
        this.iterations = iterations;
        return this;
    }

    public BiomorphGenerate WithThershold(double threshold)
    {
        this.threshold = threshold;
        return this;
    }

    public BiomorphGenerate WithMethod(Iterate method)
    {
        this.method = method;
        return this;
    }

    //</editor-fold>

    public void Default()
    {
        point_a = new MyPoint(-2.0, 2.0);
        point_b = new MyPoint(2.0, -2.0);
        size = 700;
        iterations = 30;
        threshold = 100.0;
        method = new Iterate();
        method.setEquationPolynomial(new Complex(0,0),1.0,0.0,3.0,0.0);
        method.setIterationPicard(0.5);
    }

    private boolean MagnitudeCheck(Complex x, int method)
    {
        switch(method)
        {
            case 1:
                if (FastMath.abs(x.getReal())+FastMath.abs(x.getImaginary())>threshold)
                    return true;
                break;
            case 2:
                if (x.abs() > threshold)
                    return true;
                break;
            case 3:
                if (FastMath.sqrt(FastMath.pow(x.getReal(),2)+FastMath.pow(x.getImaginary(),2))>threshold)
                    return true;
                break;
        }
        return false;
    }

    class MyCallable implements Callable<Integer[]> {
        private Integer[] output = new Integer[3];
        private Iterate innerMethod;
        private double threshold;
        private int iterations;
        private MyPoint point_a;
        private MyPoint point_b;
        private double step;
        private int i;
        private int j;

        public MyCallable(
                int i,
                int j,
                Iterate method,
                double step,
                MyPoint point_a,
                MyPoint point_b,
                double threshold,
                int iterations)
        {
            this.i = i;
            this.j = j;
            innerMethod = method;
            this.threshold = threshold;
            this.iterations = iterations;
            this.point_a = point_a;
            this.point_b = point_b;
            this.step = step;
        }

        private boolean MagnitudeCheck(Complex x, int method)
        {
            switch(method)
            {
                case 1:
                    if (FastMath.abs(x.getReal())+FastMath.abs(x.getImaginary())>threshold)
                        return true;
                case 2:
                    if (x.abs() > threshold)
                        return true;
                case 3:
                    if (FastMath.sqrt(FastMath.pow(x.getReal(), 2) + FastMath.pow(x.getImaginary(), 2))>threshold)
                        return true;
            }
            return false;
        }

        @Override
        public Integer[] call() throws Exception {

            method.setInput(new Complex(i*step+point_a.GetX(),j*step-point_a.GetY()));

            output[2] = -1;
            for (int l = 0; l<iterations;l++)
            {
                method.Calculate(true);
                if (MagnitudeCheck(method.getInput(),1))
                {
                    output[2] = l;
                    break;
                }
            }
            if (output[2] != -1)
                if ((FastMath.abs(method.getInput().getReal())<threshold||FastMath.abs(method.getInput().getImaginary())<threshold))
                    output[2] = -1;

            output[0] = i;
            output[1] = j;

            return output;
        }

    }

    private void generate_single()
    {
        double step = FastMath.abs(point_a.GetX()-point_b.GetX())/size;

        int[][] tmp = new int[size][size];

        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
            {
                method.setInput(new Complex(i*step+point_a.GetX(),j*step-point_a.GetY()));
                Complex rslt = new Complex(0.0,0.0);
                tmp[i][j] = -1;
                for (int l = 0; l<iterations;l++)
                {
                    rslt = method.Calculate(true);
                    if (MagnitudeCheck(rslt,magCheck))
                    {
                        tmp[i][j] = l;
                        break;
                    }
                }
                if (tmp[i][j] != -1)
                    if ((FastMath.abs(rslt.getReal())<threshold||FastMath.abs(rslt.getImaginary())<threshold))
                        tmp[i][j] = -1;
            }
        }

        biomorph = new Biomorph(size, iterations, tmp, "undescribed");
    }

    private void generate_muliticore()
    {
        double step = FastMath.abs(point_a.GetX()-point_b.GetX())/size;
        //  System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Integer[]>> list = new ArrayList<Future<Integer[]>>();


        int[][] tmp = new int[size][size];

        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
            {
                Callable<Integer[]> worker = new MyCallable(i,j,method,step, point_a, point_b,threshold,iterations);
                Future<Integer[]> submit = executor.submit(worker);
                list.add(submit);
            }
        }

        for (Future<Integer[]> future : list)
        {
            try {
                Integer[] tmpb = future.get();
                tmp[tmpb[0]][tmpb[1]] = tmpb[2];
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        biomorph = new Biomorph(size, iterations, tmp, "undescribed");
        executor.shutdown();
    }

    public Biomorph GetBiomorph(boolean multicore)
    {
        if (multicore)
            generate_muliticore();
        else
            generate_single();

        return biomorph;
    }
    public Biomorph GetBiomorph()
    {
        return GetBiomorph(false);
    }
}
