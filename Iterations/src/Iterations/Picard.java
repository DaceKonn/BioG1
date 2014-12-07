package Iterations;

import Equations.Equation;

import Equations.EquationBuilder;
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
    public Picard(EquationBuilder equationBuilder, double u)
    {
        super(equationBuilder);
        this.u = u;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {

        //Complex tmp = equation.Calculate().add(u);
        Complex tmp = eqBuilder.GetValue().add(u);
        if (withUpdate)
        {
            //equation.setInput(tmp);
            eqBuilder.ChangeInput(tmp);
        }
        return tmp;
    }
}
