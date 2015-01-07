package Iterations.IterationTypes;

import Equations.Equation;
import Equations.EquationBuilder;
import Iterations.AbstractIteration;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 07.01.15.
 */
public class Suantai extends AbstractIteration
{
    private double alpha;
    private double beta;
    private double gamma;

    public Suantai(Equation equation, double alpha, double beta, double gamma)
    {
        super(equation);
        this.alpha = alpha;
        this.beta = beta;
        this.gamma = gamma;
    }
    public Suantai(EquationBuilder equationBuilder, double alpha, double beta, double gamma)
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

       // eqBuilder.ChangeInput(z);

        Complex y = x.multiply(1-alpha-beta)
                .add(eqBuilder.ChangeInput(z).GetValue().multiply(alpha))
                .add(eqBuilder.ChangeInput(x).GetValue().multiply(beta));

        //eqBuilder.ChangeInput(y);

        Complex tmp = x.multiply(1-alpha-beta)
                .add(eqBuilder.ChangeInput(y).GetValue().multiply(alpha))
                .add(eqBuilder.ChangeInput(z).GetValue().multiply(beta));

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
