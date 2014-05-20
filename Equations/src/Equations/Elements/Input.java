package Equations.Elements;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 17.05.14.
 */
public class Input extends EquationElement {

    public Input(Complex input)
    {
        value = input;
        type = "input";
    }

    @Override
    public void SetBaseInput(Complex input)
    {

    }

    @Override
    public EquationElement GetCopy() {
        return new Input(new Complex(value.getReal(), value.getImaginary()));
    }
}
