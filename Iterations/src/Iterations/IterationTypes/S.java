package Iterations.IterationTypes;

import Equations.Equation;
import Equations.EquationBuilder;
import Iterations.AbstractIteration;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 07.01.15.
 */
public class S extends AbstractIteration
{
    private double alpha;
    private double beta;

    public S (Equation equation, double alpha, double beta)
    {
        super(equation);
        this.alpha = alpha;
        this.beta = beta;
    }
    public S (EquationBuilder equationBuilder, double alpha, double beta)
    {
        super(equationBuilder);
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {
        
        Complex x = eqBuilder.GetInput();

        Complex y = eqBuilder.GetInput().multiply(1-beta).add(eqBuilder.GetValue().multiply(beta));

        Complex tmp = eqBuilder.GetValue().multiply(1 - alpha).add(eqBuilder.ChangeInput(y).GetValue().multiply(alpha));

        if (withUpdate)
        {
            //equation.setInput(tmp);
            eqBuilder.ChangeInput(tmp);
        }
        else {
            eqBuilder.ChangeInput(x);
        }
        return tmp;
    }
}