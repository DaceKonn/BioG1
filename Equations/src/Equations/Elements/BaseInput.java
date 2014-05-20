package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 18.05.14.
 */
public class BaseInput extends EquationElement {

    public BaseInput(Complex input)
    {
        value = input;
        type = "input";
    }

    @Override
    public void SetBaseInput(Complex input)
    {
        value = input;
    }

    @Override
    public EquationElement GetCopy() {
        return new BaseInput(new Complex(value.getReal(), value.getImaginary()));
    }
}
