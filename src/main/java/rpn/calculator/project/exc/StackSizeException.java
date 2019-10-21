package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class StackSizeException extends Exception
{
	public StackSizeException()
	{
	    System.out.println("There is no second operand 😟 !");
	}
}
