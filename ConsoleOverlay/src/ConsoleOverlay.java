import BiomorphGenerate.*;
import Equations.Equation;
import Equations.EquationBuilder;
import org.apache.commons.math3.complex.Complex;

/**
 * Created by harold on 27.04.14.
 */

public class ConsoleOverlay
{
    public static void main(String args[])
    {
        System.out.println("BiomorphGenerate.BiomorphGenerate - ConsoleOverlay");

        EquationBuilder eq = new EquationBuilder(new Complex(2.0, 2.0));
        eq.PredefinedPolinomialSimple(2.0,2.0,1.0,1.0);
        EquationBuilder eqb = new EquationBuilder(eq);
        eqb.Sinus();
        eqb.Close();
      //  System.out.println("Equation: "+eq.GetEquationString());
      // eq.Close();
       //
       // eq.Multiply(new Complex(5.0, 5.0));
       // eq.CloseAll();
        System.out.println("Equation: " + eq.GetEquationString());
        System.out.println("Result: "+eq.GetValue());
        eq.ChangeInput(new Complex(3.0, 3.0));
       // System.out.println("Input: "+eqb.GetInput());
        System.out.println("Equation: " + eqb.GetEquationString());
        System.out.println("Result: "+eqb.GetValue());
       // System.out.println("Input: "+eqb.GetInput());
        System.out.println("Equation: "+eqb.GetEquationString());
        System.out.println("Result: "+eqb.GetValue());
       // System.out.println("Input: "+eqb.GetInput());
        System.out.println(new Complex(1.0,1.0).pow(new Complex(-2.0, 2.0)));



        Biomorph bm = new Biomorph(12,21);
        System.out.println(bm.GetGridString());
      //  System.out.println(bm.toString());

        long time = System.nanoTime();
        BiomorphGenerate bg = new BiomorphGenerate();
        bg.Default();
     /*   bm = bg.GetBiomorph(true);
        System.out.println("Generated multicore: "+((System.nanoTime() - time)/1000000));
        bm.GetGridString();
        System.out.println();
        time = (System.nanoTime() - time)/1000000;
        System.out.println("Miliseconds elapsed: "+time);*/

        System.out.println();

        time = System.nanoTime();
        bg = new BiomorphGenerate();
        bg.Default();
        bm = bg.GetBiomorph(false);
        System.out.println("Generated singlecore: "+((System.nanoTime() - time)/1000000));
     //  System.out.println( bm.GetGridString());
        System.out.println();
        time = (System.nanoTime() - time)/1000000;
        System.out.println("Miliseconds elapsed: "+time);
    }
}
