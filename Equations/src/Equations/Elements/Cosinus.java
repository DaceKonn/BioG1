package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 18.05.14.
 */
public class Cosinus extends EquationElement{
    EquationElement a;

    public Cosinus(EquationElement A)
    {
        a = A;
        type = "cosinus";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().cos();
    }

    @Override
    public String GetEquationString()
    {
        return "cos( "+a.GetEquationString()+" )";
    }

    @Override
    public void SetBaseInput(Complex input) {
        a.SetBaseInput(input);
    }

    @Override
    public EquationElement GetCopy() {
        return new Cosinus(a.GetCopy());
    }
}