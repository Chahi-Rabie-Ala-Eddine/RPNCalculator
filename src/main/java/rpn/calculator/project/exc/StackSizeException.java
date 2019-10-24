package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class StackSizeException extends Exception
{
	public StackSizeException()
	{
	    System.err.println("\n\n                 ⚠️ There is no second operand ⚠️");
	}
}
