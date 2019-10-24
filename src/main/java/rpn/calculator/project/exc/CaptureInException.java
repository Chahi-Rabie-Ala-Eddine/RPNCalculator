package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class CaptureInException extends Exception
{
	public CaptureInException()
	{
		System.err.println("\n\n                 ⚠️ Your ⌨️ input is wrong ⚠️\n");
	}
}
