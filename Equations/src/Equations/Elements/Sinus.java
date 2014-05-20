package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 18.05.14.
 */
public class Sinus extends EquationElement{
    EquationElement a;

    public Sinus(EquationElement A)
    {
        a = A;
        type = "sinus";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().sin();
    }

    @Override
    public String GetEquationString()
    {
        return "sin( "+a.GetEquationString()+" )";
    }

    @Override
    public void SetBaseInput(Complex input) {
        a.SetBaseInput(input);
    }

    @Override
    public EquationElement GetCopy() {
        return new Sinus(a.GetCopy());
    }
}
