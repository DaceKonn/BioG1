package Equations.Elements;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 17.05.14.
 */
public class Add extends EquationJoin{

    public Add(EquationElement A, EquationElement B)
    {
        super(A,B);
        type = "add";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().add(b.GetValue());
    }

    @Override
    public String GetEquationString()
    {
        return "["+a.GetEquationString()+" + "+b.GetEquationString()+"]";
    }

    @Override
    public EquationElement GetCopy() {
        return new Add(a.GetCopy(),b.GetCopy());
    }
}