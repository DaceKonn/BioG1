package Iterations.IterationTypes;

import Equations.Equation;
import Equations.EquationBuilder;
import Iterations.AbstractIteration;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 08.01.15.
 */
public class TwoStepMann extends AbstractIteration
{
    private double alpha;
    private double beta;

    public TwoStepMann(Equation equation, double alpha, double beta)
    {
        super(equation);
        this.alpha = alpha;
        this.beta = beta;
    }
    public TwoStepMann(EquationBuilder equationBuilder, double alpha, double beta)
    {
        super(equationBuilder);
        this.alpha = alpha;
        this.beta = beta;
    }

    @Override
    public Complex Calculate(boolean withUpdate)
    {

        //Complex tmp = equation.Calculate().add(u);

        Complex x = eqBuilder.GetInput();

        Complex y = eqBuilder.GetInput().multiply(1-beta).add(eqBuilder.GetValue().multiply(beta));

        //Complex tmp = eqBuilder.GetInput().multiply(1-beta).add(eqBuilder.GetValue().multiply(beta));

        eqBuilder.ChangeInput(y);

        Complex tmp = eqBuilder.GetInput().multiply(1-alpha).add(eqBuilder.GetValue().multiply(alpha));



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
