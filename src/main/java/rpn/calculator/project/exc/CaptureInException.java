package rpn.calculator.project.exc;

@SuppressWarnings("serial")

public class CaptureInException extends Exception
{
	public CaptureInException()
	{
		System.out.println("Your keyboard input is wrong \n");
	}
}
