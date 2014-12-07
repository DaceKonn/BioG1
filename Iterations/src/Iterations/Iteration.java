package Iterations;

import Equations.Equation;
import Equations.EquationBuilder;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 29.04.14.
 */
abstract public class Iteration
{
    //private Complex input;
    protected Equation equation;
    protected EquationBuilder eqBuilder;

    public Iteration(Equation equation)
    {
        //this.input = input;
        this.equation = equation;
    }
    public Iteration(EquationBuilder equationBuilder)
    {
        //this.input = input;
        this.eqBuilder = new EquationBuilder(equationBuilder);
    }

    public Complex getInput()
    {
        //return equation.getInput();
        return eqBuilder.input;
    }

    public void setInput(Complex input)
    {
       // equation.setInput(input);
        eqBuilder.ChangeInput(input);
    }

    abstract public Complex Calculate(boolean withUpdate);

}
