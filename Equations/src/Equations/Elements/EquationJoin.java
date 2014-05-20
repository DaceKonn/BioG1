package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 17.05.14.
 */
public class EquationJoin extends EquationElement {

    EquationElement a;
    EquationElement b;

    public EquationJoin(EquationElement A, EquationElement B)
    {
        a = A;
        b = B;

        type = "join";
    }

    @Override
    public void SetBaseInput(Complex input)
    {
        a.SetBaseInput(input);
        b.SetBaseInput(input);
    }

    @Override
    public EquationElement GetCopy() {
        return new EquationJoin(a.GetCopy(),b.GetCopy());
    }
}
