package Iterations;

import Equations.Equation;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 09.05.14.
 */
public class Picard extends Iteration
{
    private double u;

    public Picard(Equation equation, double u)
    {
        super(equation);
        this.u = u;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {
        Complex tmp = equation.Calculate().add(u);
        if (withUpdate)
        {
            equation.setInput(tmp);
        }
        return tmp;
    }
}
