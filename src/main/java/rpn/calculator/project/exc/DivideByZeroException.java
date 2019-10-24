package rpn.calculator.project.exc;

/**
 * This exception is thrown when the user try to divide by zero
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
@SuppressWarnings("serial")

public class DivideByZeroException extends Exception
{
	/**
	 * DivideByZeroException Constructor
	 */
	public DivideByZeroException()
	{
	    System.err.println("\n\n                   ⚠️ U are dividing by zéro ⚠️");
	}
}
