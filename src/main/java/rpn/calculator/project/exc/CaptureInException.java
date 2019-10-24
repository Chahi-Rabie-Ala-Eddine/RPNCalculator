package rpn.calculator.project.exc;

/**
 * This exception is thrown when the input is different than a number or an operation or exit
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
@SuppressWarnings("serial")

public class CaptureInException extends Exception
{
	/**
	 * CaptureInException Constructor
	 */
	public CaptureInException()
	{
		System.err.println("\n\n                 ⚠️ Your ⌨️ input is wrong ⚠️\n");
	}
}
