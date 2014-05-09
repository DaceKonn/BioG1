/**
 * Created by harold on 27.04.14.
 */
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.util.FastMath;

import java.awt.*;

import java.util.*;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    private static final int NTHREDS = 10;



    public BiomorphGenerate()
    {
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
                if (FastMath.sqrt(FastMath.pow(x.getReal(),2)+FastMath.pow(x.getImaginary(),2))>threshold)
                    return true;
        }
        return false;
    }

    class MyCallable implements Callable<Integer> {
        private int output;
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

        @Override
        public Integer call() throws Exception {

            method.setInput(new Complex(i*step+point_a.GetX(),j*step-point_a.GetY()));

            output = -1;
            for (int l = 0; l<iterations;l++)
            {
                method.Calculate(true);
                if (MagnitudeCheck(method.getInput(),magCheck))
                {
                    output = l;
                    break;
                }
            }
            if (output != -1)
                if ((FastMath.abs(method.getInput().getReal())<threshold||FastMath.abs(method.getInput().getImaginary())<threshold))
                    output = -1;

            return output;
        }

    }

    private void generate()
    {
        double step = FastMath.abs(point_a.GetX()-point_b.GetX())/size;

        ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        int[][] tmp = new int[size][size];

        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
            {
                Callable<Integer> worker = new MyCallable(i,j,method,step, point_a, point_b,threshold,iterations);
                Future<Integer> submit = executor.submit(worker);
                list.add(submit);

                //method.setInput(new Complex(i*step-centring-view_control.getOffset_x(),j*step-centring-view_control.getOffset_y()));
                /*method.setInput(new Complex(i*step+point_a.GetX(),j*step-point_a.GetY()));

                tmp[i][j] = -1;
                for (int l = 0; l<iterations;l++)
                {
                    method.Calculate(true);
                    if (MagnitudeCheck(method.getInput(),magCheck))
                    {
                        tmp[i][j] = l;
                        break;
                    }
                }
                if (tmp[i][j] != -1)
                    if ((FastMath.abs(method.getInput().getReal())<threshold||FastMath.abs(method.getInput().getImaginary())<threshold))
                        tmp[i][j] = -1;*/
            }
        }

        int counter = 0;
        for (Future<Integer> future : list)
        {
            try {
                tmp[counter%size][(int)FastMath.floor(counter/size)] = future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
