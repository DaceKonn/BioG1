package Equations.Elements;

import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 17.05.14.
 */
public class Multiply extends EquationJoin {

    public Multiply(EquationElement A, EquationElement B)
    {
        super(A,B);
        type = "multiply";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().multiply(b.GetValue());
    }

    @Override
    public String GetEquationString()
    {
        return "["+a.GetEquationString()+" * "+b.GetEquationString()+"]";
    }

    @Override
    public EquationElement GetCopy() {
        return new Multiply(a.GetCopy(),b.GetCopy());
    }
}
