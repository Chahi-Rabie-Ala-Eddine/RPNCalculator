package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class DivideByZeroException extends Exception
{
	public DivideByZeroException()
	{
	    System.out.println("U are dividing by zéro 😟 !");
	}
}
