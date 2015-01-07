package Iterations;

import Equations.Equation;
import Equations.EquationBuilder;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 07.01.15.
 */
public class Ishikawa extends Iteration
{
    private double alpha;
    private double beta;

    public Ishikawa(Equation equation, double alpha, double beta)
    {
        super(equation);
        this.alpha = alpha;
        this.beta = beta;
    }
    public Ishikawa(EquationBuilder equationBuilder, double alpha, double beta)
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

        Complex tmp = eqBuilder.GetInput().multiply(1-alpha).add(eqBuilder.GetValue().multiply(alpha));

        eqBuilder.ChangeInput(tmp);

        tmp = eqBuilder.GetInput().multiply(1-beta).add(eqBuilder.GetValue().multiply(beta));



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