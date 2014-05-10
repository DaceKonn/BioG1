package Equations;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 29.04.14.
 */
abstract public class Equation
{
    private Complex input;

    public Equation(Complex input)
    {
        this.input = input;
    }

    public Complex getInput()
    {
        return input;
    }

    public void setInput(Complex input)
    {
        this.input = input;
    }

    abstract public Complex Calculate();

    abstract public Complex CalculateDiff();
}