package Equations;
import Equations.Elements.*;
import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;

/**
 * Created by harold on 17.05.14.
 */
public class EquationBuilder {

    public Complex input;
    public ArrayList<EquationElement> left;
    public ArrayList<String> joins;

    public EquationBuilder(Complex input)
    {
        this.input = input;
        this.left = new ArrayList<EquationElement>();
        this.joins = new ArrayList<String>();
        this.left.add(new BaseInput(input));
    }

    public EquationBuilder(EquationBuilder equation)
    {
        this.input = new Complex(equation.input.getReal(), equation.input.getImaginary());
        this.joins = new ArrayList<String>(equation.joins);
        this.left = new ArrayList<EquationElement>();
        for(EquationElement e : equation.left)
            this.left.add(e.GetCopy());
    }

    public void ChangeInput(Complex input)
    {
        CloseAll();
        this.input = input;
        left.get(0).SetBaseInput(input);
    }

    public String GetLeft()
    {
        String output = "";
        for (EquationElement elem : left)
        {
            output += "[ " +elem.GetEquationString()+" ]\n";
        }
        return output;
    }

    public String GetJoins()
    {
        String output = "";
        for (String str : joins)
        {
            output += "[ " +str+" ]\n";
        }
        return output;
    }

    public Complex GetValue()
    {
        CloseAll();
        Complex tmp; //= left.get(0).GetValue();
        tmp = input.pow(3.0);//input.pow(2.0).multiply(1.0).add(input.pow(0.0).multiply(0.0));
        if (tmp.isNaN())
        {
            tmp = new Complex(0.0,0.0);
        }
        return tmp;
    }

    public String GetEquationString()
    {
        CloseAll();
        return left.get(0).GetEquationString();
    }

    public void CloseAll()
    {
        while (joins.size() > 0 && left.size() > 1)
        {
            Close();
        }
    }

    public void Close()
    {
        if (joins.size() > 0 && left.size() > 1)
        {
            int topJoin = joins.size()-1;
            int topLeft = left.size()-1;

            String operation = joins.get(topJoin);

            if(operation == "add")
            {
                left.set(topLeft - 1, new Add(left.get(topLeft - 1), left.get(topLeft)));
            }
            else if(operation == "substract")
            {
                left.set(topLeft - 1, new Substract(left.get(topLeft - 1), left.get(topLeft)));
            }
            else if(operation == "multiply")
            {
                left.set(topLeft - 1, new Multiply(left.get(topLeft - 1), left.get(topLeft)));
            }
            else if(operation == "devide")
            {
                left.set(topLeft-1, new Devide(left.get(topLeft-1), left.get(topLeft)));
            }
            left.remove(topLeft);
            joins.remove(topJoin);
        }
    }

    private void Input(Complex input, boolean base)
    {
        if (base)
            left.add(new BaseInput(input));
        else
            left.add(new Input(input));
    }

    public void Power(Complex param)
    {
        int top = left.size()-1;

        EquationElement tmp = new Power(left.get(top), param);
        left.set(top, tmp);
    }

    public void Sinus()
    {
        int top = left.size()-1;

        EquationElement tmp = new Sinus(left.get(top));
        left.set(top, tmp);
    }

    public void Cosinus()
    {
        int top = left.size()-1;

        EquationElement tmp = new Cosinus(left.get(top));
        left.set(top, tmp);
    }

    public void Tangens()
    {
        int top = left.size()-1;

        EquationElement tmp = new Tangens(left.get(top));
        left.set(top, tmp);
    }

    public void Add(Complex param, boolean base)
    {
        joins.add("add");
        Input(param, base);
    }

    public void Multiply(Complex param, boolean base)
    {
        joins.add("multiply");
        Input(param, base);
    }

    public void Devide(Complex param, boolean base)
    {
        joins.add("devide");
        Input(param, base);
    }

    public void PredefinedPolinomialSimple(double a, double b, double m, double n)
    {
        Power(new Complex(m, 0.0));
        //Multiply(new Complex(a, 0.0), false);
        Close();
        //Add(input, true);
        //Power(new Complex(n, 0.0));
        //Multiply(new Complex(b, 0.0), false);
        CloseAll();
    }
}
