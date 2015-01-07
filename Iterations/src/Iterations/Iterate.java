package Iterations;

import Equations.Equation;
import Equations.EquationBuilder;
import Exceptions.CustomException;
import Iterations.IterationTypes.*;
import org.apache.commons.math3.complex.Complex;
/**
 * Created by harold on 29.04.14.
 */
public class Iterate {
    private Equation equation;
    private EquationBuilder eqBuilder;
    private AbstractIteration abstractIteration;
    private boolean equation_set = false;
    private boolean iteration_set = false;

    public Iterate()
    {

    }



    public Complex Calculate(boolean withUpdate)
    {
        if (equation_set&iteration_set)
        {
            return abstractIteration.Calculate(withUpdate);
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
            return abstractIteration.getInput();
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
            abstractIteration.setInput(input);
        }
        else
        {
          //  parent.println("Error: In Iterations.Iterate - equation or iteration is not set");
        }
    }

    public void setEquationPolynomial(Complex input, double ex, double fx, double xpa, double xpb)
    {
        eqBuilder = new EquationBuilder(input);
        eqBuilder.PredefinedPolinomialSimple(ex, fx, xpa, xpb);
        equation_set = true;
    }

    public void setEquationSin(Complex input, double ex, double fx, double xpb) throws CustomException
    {
      //  equation = new Equation_Sin(parent, input, ex, fx, xpb);
        equation_set = true;
        throw new CustomException("Iteration Ishikawa not implemented");
    }

    public void setIterationPicard(double u)
    {
        if (equation_set)
        {
           // iteration = new Picard(equation,u);
            abstractIteration = new Picard(eqBuilder,u);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
    }

    public void setIterationMann(double alpha) throws CustomException {

        if (equation_set)
        {
          //  iteration = new Iteration_Mann(parent,equation,alpha);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Mann not implemented");
    }

    public void setIterationIshikawa(double alpha, double beta) throws CustomException
    {
        if (equation_set)
        {
        //    iteration = new Iteration_Ishikawa(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Ishikawa not implemented");
    }

    public void setIterationNoor(double alpha, double beta, double c) throws CustomException
    {
        if (equation_set)
        {
       //     iteration = new Iteration_Noor(parent,equation,alpha,beta,c);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Noor not implemented");
    }

    public void setIterationSuantai(double alpha, double beta, double a, double b, double c) throws CustomException
    {
        if (equation_set)
        {
        //    iteration = new Iteration_Suantai(parent,equation,alpha,beta,a,b,c);
            iteration_set = true;
        }
       // else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Suntai not implemented");
    }

    public void setIterationS(double alpha, double beta) throws CustomException
    {
        if (equation_set)
        {
        //    iteration = new Iteration_S(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration IterationS not implemented");
    }

    public void setIterationTwoStepMann(double alpha, double beta) throws CustomException
    {
        if (equation_set)
        {
        //    iteration = new Iteration_TwoStepMann(parent,equation,alpha,beta);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Two Step Mann not implemented");
    }

    public void setIterationSP(double alpha, double beta, double c) throws CustomException
    {
        if (equation_set)
        {
          //  iteration = new Iteration_SP(parent,equation,alpha,beta,c);
            iteration_set = true;
        }
       // else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration SP not implemented");
    }

    public void setIterationNew(double alpha, double beta, double a, double b, double c) throws CustomException
    {
        if (equation_set)
        {
       //     iteration = new Iteration_New(parent,equation,alpha,beta,a,b,c);
            iteration_set = true;
        }
     //   else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration NEW not implemented");
    }
}
