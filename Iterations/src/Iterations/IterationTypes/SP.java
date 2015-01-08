package Iterations.IterationTypes;

import Equations.Equation;
import Equations.EquationBuilder;
import Iterations.AbstractIteration;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 08.01.15.
 */
public class SP extends AbstractIteration
{
    private double alpha;
    private double beta;
    private double gamma;

    public SP(Equation equation, double alpha, double beta, double gamma)
    {
        super(equation);
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }
    public SP(EquationBuilder equationBuilder, double alpha, double beta, double gamma)
    {
        super(equationBuilder);
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {



        Complex x = eqBuilder.GetInput();

        Complex z = eqBuilder.GetInput().multiply(1-gamma).add(eqBuilder.GetValue().multiply(gamma));

        eqBuilder.ChangeInput(z);

        Complex y = eqBuilder.GetInput().multiply(1 - beta).add(eqBuilder.GetValue().multiply(beta));

        eqBuilder.ChangeInput(y);

        Complex tmp = eqBuilder.GetInput().multiply(1 - alpha).add(eqBuilder.GetValue().multiply(alpha));

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