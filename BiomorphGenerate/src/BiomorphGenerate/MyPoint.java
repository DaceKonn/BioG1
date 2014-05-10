package BiomorphGenerate;

import org.apache.commons.math3.ml.distance.DistanceMeasure;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by harold on 28.04.14.
 */
public class MyPoint {
    private double x;
    private double y;

    public MyPoint(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double GetX()
    {return x;}
    private void SetX(double value)
    {x = value;}

    public double GetY()
    {return y;}
    private void SetY(double value)
    {y = value;}

    public double[] GetAsArray()
    {return new double[] {x,y};}
}