package Iterations;

import Equations.Equation;

import Equations.EquationBuilder;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 07.01.15.
 */
public class Mann extends Iteration
{
    private double alpha;

    public Mann(Equation equation, double alpha)
    {
        super(equation);
        this.alpha = alpha;
    }
    public Mann(EquationBuilder equationBuilder, double alpha)
    {
        super(equationBuilder);
        this.alpha = alpha;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {

        //Complex tmp = equation.Calculate().add(u);
        Complex tmp = eqBuilder.GetInput().multiply(1-alpha).add(eqBuilder.GetValue().multiply(alpha));
        if (withUpdate)
        {
            //equation.setInput(tmp);
            eqBuilder.ChangeInput(tmp);
        }
        return tmp;
    }
}