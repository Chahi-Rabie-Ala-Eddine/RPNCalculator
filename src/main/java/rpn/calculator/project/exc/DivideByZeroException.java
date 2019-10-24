package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class DivideByZeroException extends Exception
{
	public DivideByZeroException()
	{
	    System.err.println("\n\n                   ⚠️ U are dividing by zéro ⚠️");
	}
}
