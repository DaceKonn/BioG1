package Iterations;

import Equations.Equation;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 29.04.14.
 */
abstract public class Iteration
{
    //private Complex input;
    protected Equation equation;

    public Iteration(Equation equation)
    {
        //this.input = input;
        this.equation = equation;
    }

    public Complex getInput()
    {
        return equation.getInput();
    }

    public void setInput(Complex input)
    {
        equation.setInput(input);
    }

    abstract public Complex Calculate(boolean withUpdate);

}
