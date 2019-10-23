package rpn.calculator.project.src;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import rpn.calculator.project.exc.*;

public class CaptureRPNTest 
{
	private CaptureRPN capture;
	private boolean test = false;
	private final static char operand = '4';
	private final static String carriageReturn = "\n";
	private final static String exit = "exit";
	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void captureOneElementTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == 4.0);
		assertEquals(test,true);
	}
	  
}
