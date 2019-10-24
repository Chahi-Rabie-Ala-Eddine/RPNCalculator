package rpn.calculator.project.exc;

/**
 * This exception is thrown when the stack size is inappropriate to do an operation
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
@SuppressWarnings("serial")

public class StackSizeException extends Exception
{
	/**
	 * DivideByZeroException Constructor
	 */
	public StackSizeException()
	{
	    System.err.println("\n\n                 ⚠️ There is no second operand ⚠️");
	}
}
