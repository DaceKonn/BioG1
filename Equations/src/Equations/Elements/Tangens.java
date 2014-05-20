package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 18.05.14.
 */
public class Tangens extends EquationElement{
    EquationElement a;

    public Tangens(EquationElement A)
    {
        a = A;
        type = "sinus";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().tan();
    }

    @Override
    public String GetEquationString()
    {
        return "tan( "+a.GetEquationString()+" )";
    }

    @Override
    public void SetBaseInput(Complex input) {
        a.SetBaseInput(input);
    }

    @Override
    public EquationElement GetCopy() {
        return new Tangens(a.GetCopy());
    }
}
