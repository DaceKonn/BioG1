/**
 * Created by harold on 27.04.14.
 */
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.util.FastMath;

import java.awt.*;


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

    private void generate()
    {
        double step = FastMath.abs(point_a.GetX()-point_b.GetX())/size;

        int[][] tmp = new int[size][size];

        for (int i = 0; i<size; i++)
        {
            for (int j = 0; j<size; j++)
            {
                //method.setInput(new Complex(i*step-centring-view_control.getOffset_x(),j*step-centring-view_control.getOffset_y()));
                method.setInput(new Complex(i*step+point_a.GetX(),j*step-point_a.GetY()));

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
                        tmp[i][j] = -1;
            }
        }
    }
}
