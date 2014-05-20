package Equations.Elements;
import org.apache.commons.math3.complex.Complex;



/**
 * Created by harold on 17.05.14.
 */
abstract public class EquationElement {
    protected String type = "none";
    protected Complex value = new Complex(0, 0);

    public Complex GetValue()
    {
        return value;
    }

    public String GetType()
    {
        return type;
    }

    public String GetEquationString()
    {
        return "{"+value.getReal()+"+"+value.getImaginary()+"i}";
    }

    public abstract void SetBaseInput(Complex input);

    public abstract EquationElement GetCopy();
}
