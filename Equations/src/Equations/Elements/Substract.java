package Equations.Elements;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 17.05.14.
 */
public class Substract extends EquationJoin {
    public Substract(EquationElement a, EquationElement b) {
        super(a, b);
        type = "substract";
    }

    @Override
    public Complex GetValue() {
        return a.GetValue().subtract(b.GetValue());
    }

    @Override
    public String GetEquationString() {
        return a.GetEquationString() + " - " + b.GetEquationString();
    }

    @Override
    public EquationElement GetCopy() {
        return new Substract(a.GetCopy(),b.GetCopy());
    }
}