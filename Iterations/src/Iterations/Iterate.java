package Iterations;

import Equations.Equation;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 29.04.14.
 */
public class Iterate {
    private Equation equation;
    private Iteration iteration;
    private boolean equation_set = false;
    private boolean iteration_set = false;

    public Iterate()
    {

    }



    public Complex Calculate(boolean withUpdate)
    {
        if (equation_set&iteration_set)
        {
            return iteration.Calculate(withUpdate);
        }
        else
        {
            //parent.println("Error: In Iterations.Iterate - equation or iteration is not set");
            return null;
        }
    }

    public Complex getInput()
    {
        if (equation_set&iteration_set)
        {
            return iteration.getInput();
        }
        else
        {
           // parent.println("Error: In Iterations.Iterate - equation or iteration is not set");
            return null;
        }
    }

    public void setInput(Complex input)
    {
        if (equation_set&iteration_set)
        {
            iteration.setInput(input);
        }
        else
        {
          //  parent.println("Error: In Iterations.Iterate - equation or iteration is not set");
        }
    }

    public void setEquationPolynomial(Complex input, double ex, double fx, double xpa, double xpb)
    {
        equation = new Equations.Polynomial(input, ex, fx, xpa, xpb);
        equation_set = true;
    }

    public void setEquationSin(Complex input, double ex, double fx, double xpb)
    {
      //  equation = new Equation_Sin(parent, input, ex, fx, xpb);
        equation_set = true;
    }

    public void setIterationPicard(double u)
    {
        if (equation_set)
        {
            iteration = new Picard(equation,u);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationMann(double alpha)
    {
        if (equation_set)
        {
          //  iteration = new Iteration_Mann(parent,equation,alpha);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationIshikawa(double alpha, double beta)
    {
        if (equation_set)
        {
        //    iteration = new Iteration_Ishikawa(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationNoor(double alpha, double beta, double c)
    {
        if (equation_set)
        {
       //     iteration = new Iteration_Noor(parent,equation,alpha,beta,c);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationSuantai(double alpha, double beta, double a, double b, double c)
    {
        if (equation_set)
        {
        //    iteration = new Iteration_Suantai(parent,equation,alpha,beta,a,b,c);
            iteration_set = true;
        }
       // else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationS(double alpha, double beta)
    {
        if (equation_set)
        {
        //    iteration = new Iteration_S(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationTwoStepMann(double alpha, double beta)
    {
        if (equation_set)
        {
        //    iteration = new Iteration_TwoStepMann(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationSP(double alpha, double beta, double c)
    {
        if (equation_set)
        {
          //  iteration = new Iteration_SP(parent,equation,alpha,beta,c);
            iteration_set = true;
        }
       // else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationNew(double alpha, double beta, double a, double b, double c)
    {
        if (equation_set)
        {
       //     iteration = new Iteration_New(parent,equation,alpha,beta,a,b,c);
            iteration_set = true;
        }
     //   else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }
}
