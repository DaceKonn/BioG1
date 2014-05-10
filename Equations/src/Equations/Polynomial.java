package Equations;

import Equations.Equation;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 09.05.14.
 */
public class Polynomial extends Equation
{
    private double fx;
    private double ex;
    private double xpn;
    private double xpm;

    public Polynomial(Complex input, double ex, double fx, double xpn, double xpm)
    {
        super(input);
        this.fx = fx;
        this.ex = ex;
        this.xpn = xpn;
        this.xpm = xpm;
    }

    @Override
    public Complex Calculate()
    {
        //Complex tmp = getInput().pow(xpa).multiply(ex).add(getInput().pow(xpb).multiply(fx));
        Complex tmp = getInput().pow(xpn).multiply(ex).add(getInput().pow(xpm).multiply(fx));

        if (tmp.isNaN())
        {
            tmp = new Complex(0.0,0.0);
        }

        return tmp;
    }

    @Override
    public Complex CalculateDiff()
    {
        Complex tmp = getInput().pow(xpn-1).multiply(ex).multiply(xpn).add(getInput().pow(xpm-1).multiply(fx).multiply(xpm));

        if (tmp.isNaN())
        {
            tmp = new Complex(0.0,0.0);
        }

        return tmp;
    }
}
