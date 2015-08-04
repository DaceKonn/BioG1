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

    //TODO Iterate - constructor - it's empty!
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
            //TODO Iterate - Calculate - else - what to do about it?
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
            //TODO Iterate - getInput - else - what to do about it?
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
            //TODO Iterate - setInput - else - what to do about it?
          //  parent.println("Error: In Iterations.Iterate - equation or iteration is not set");
        }
    }

    public void setEquationPolynomial(Complex input, double ex, double fx, double xpa, double xpb)
    {
        eqBuilder = new EquationBuilder(input);
        eqBuilder.PredefinedPolinomialSimple(ex, fx, xpa, xpb);
        equation_set = true;
    }

    //TODO Iterate - setEquationSin
    public void setEquationSin(Complex input, double ex, double fx, double xpb) throws CustomException
    {
      //  equation = new Equation_Sin(parent, input, ex, fx, xpb);
        equation_set = true;
        throw new CustomException("Iteration Ishikawa not implemented");
    }

    //TODO Iterate - setIterationPicard
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

    //TODO Iterate - setIterationMann
    public void setIterationMann(double alpha) throws CustomException {

        if (equation_set)
        {
          //  iteration = new Iteration_Mann(parent,equation,alpha);
            iteration_set = true;
        }
      //  else parent.println("Error: In Iterations.Iterate - can't set iteration because the equation is not set");
        throw new CustomException("Iteration Mann not implemented");
    }

    //TODO Iterate - setIterationIshikawa
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

    //TODO Iterate - setIterationNoor
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

    //TODO Iterate - setIterationSuantai
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

    //TODO Iterate - setIterationS
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

    //TODO Iterate - setIterationTwoStepMann
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

    //TODO Iterate - setIterationSP
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


    //TODO Iterate - setIterationNew
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
