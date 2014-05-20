package Equations.Elements;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 17.05.14.
 */
public class Power extends EquationElement{
    EquationElement a;
    EquationElement param;

    public Power(EquationElement A, Complex param)
    {
        a = A;
        this.param = new Input(param);
        type = "power";
    }

    @Override
    public Complex GetValue()
    {
        return a.GetValue().pow(param.GetValue());
    }

    @Override
    public String GetEquationString()
    {
        return ""+a.GetEquationString()+"^("+param.GetEquationString()+")";
    }

    @Override
    public void SetBaseInput(Complex input) {
        a.SetBaseInput(input);
    }

    @Override
    public EquationElement GetCopy() {
        return new Power(a.GetCopy(), new Complex(param.GetValue().getReal(), param.GetValue().getImaginary()));
    }


}