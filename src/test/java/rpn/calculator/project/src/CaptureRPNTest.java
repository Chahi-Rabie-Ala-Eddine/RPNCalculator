package rpn.calculator.project.src;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import rpn.calculator.project.exc.*;

public class CaptureRPNTest 
{
	private static MotorRPN motorMaxMin = new MotorRPN();
	private CaptureRPN capture;
	private boolean test = false;
	private final static String operand_one = "4";
	private final static String operand_two = "5";
	private final static String operand_zero = "0";
	private final static String operand_max = Double.toString(motorMaxMin.getMaxValue() + 1);
	private final static String operand_min = Double.toString(motorMaxMin.getMinValue() - 1);
	private final static String plus = "+";
	private final static String minus = "-";
	private final static String times = "*";
	private final static String per = "/";
	private final static String carriageReturn = "\n";
	private final static String exit = "exit";

	
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	// insertion d'un élément dans la pile
	@Test
	public void captureDoubleOneElementTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_one));
		assertEquals(test,true);
	}
		
	//insertion de deux élement dans la pile test le premier pop
	@Test
	public void captureFirstElementTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_two));
		assertEquals(test,true);
	}
	
	//insertion de deux élement dans la pile test le deuxieme pop
	@Test
	public void captureSecondElementTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    capture.getMotor().getStack().pop();
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_one));
		assertEquals(test,true);
	}
	
	//insertion de deux éléments test 
	@Test
	public void captureTwoElementTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_two));
		assertEquals(test,true);
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_one));
		assertEquals(test,true);
	}
	
	@Test
	public void captureAdditionTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + plus + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == (Double.parseDouble(operand_one) + Double.parseDouble(operand_two)));
		assertEquals(test,true);
	}

	@Test
	public void captureSubstractTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + minus + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == (Double.parseDouble(operand_one) - Double.parseDouble(operand_two)));
		assertEquals(test,true);
	}

	@Test
	public void captureMultiplyTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + times + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == (Double.parseDouble(operand_one) * Double.parseDouble(operand_two)));
		assertEquals(test,true);
	}

	@Test
	public void captureDivideTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
	    systemInMock.provideLines(operand_one + carriageReturn + operand_two + carriageReturn + per + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == (Double.parseDouble(operand_one) / Double.parseDouble(operand_two)));
		assertEquals(test,true);
	}

	@Test (expected = StackSizeException.class)
	public void captureAdditionStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + minus);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	@Test (expected = StackSizeException.class)
	public void captureSubstractStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + times);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	@Test (expected = StackSizeException.class)
	public void captureMultiplyStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + per);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	@Test (expected = DivideByZeroException.class)
	public void captureDivideByZeroTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + operand_zero + carriageReturn + per + carriageReturn + exit);
	    capture = new CaptureRPN();
	    capture.capture();
	    test = (capture.getMotor().getStack().pop() == Double.parseDouble(operand_zero));
		assertEquals(test,true);
	}
	
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void captureMinimumTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{	
		systemInMock.provideLines(operand_min);
	    capture = new CaptureRPN();
	    capture.capture();
	}

	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void CaptureMaximumTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{	
		systemInMock.provideLines(operand_max);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	
	
	@After
	public void clean()
	{
		motorMaxMin = null;
		capture = null;
	}
	
}
