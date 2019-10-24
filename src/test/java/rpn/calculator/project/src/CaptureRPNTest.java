package rpn.calculator.project.src;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import rpn.calculator.project.exc.*;

/**
 * This test class manages tests of the CaptureRPN class
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public class CaptureRPNTest 
{
	/**
	 * Attributes needed to succeed tests
	 */
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
	
	/**
	 * Initialization of the SIS
	 */
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	/**
	 * Test the capture of one element
	 */
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
		
	/**
	 * Test the capture of two elements by evaluate the stack's head
	 */
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
	
	/**
	 * Test the capture of two elements by evaluate the stack's second element
	 */
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
	
	/**
	 * Test the capture of two elements
	 */
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
	
	/**
	 * Test the capture of an addition
	 */
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

	/**
	 * Test the capture of a subtraction
	 */
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

	/**
	 * Test the capture of a multiplication
	 */
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

	/**
	 * Test the capture of a division
	 */
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

	/**
	 * Test the StacksizeException by the capture of an addition with only one operand
	 */
	@Test (expected = StackSizeException.class)
	public void captureAdditionStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + minus);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	/**
	 * Test the StacksizeException by the capture of a subtraction with only one operand
	 */
	@Test (expected = StackSizeException.class)
	public void captureSubstractStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + times);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	/**
	 * Test the StacksizeException by the capture of a multiplication with only one operand
	 */
	@Test (expected = StackSizeException.class)
	public void captureMultiplyStackSizeTest() 
		throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		systemInMock.provideLines(operand_one + carriageReturn + per);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	/**
	 * Test the StacksizeException by the capture of a division with only one operand
	 */
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
	
	/**
	 * Test the AbsoluteMinMaxValuesException by the capture of a bigger number 
	 * than the Max value supported by this calculator
	 */
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void captureMinimumTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{	
		systemInMock.provideLines(operand_min);
	    capture = new CaptureRPN();
	    capture.capture();
	}

	/**
	 * Test the AbsoluteMinMaxValuesException by the capture of a smaller number 
	 * than the Min value supported by this calculator
	 */
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void CaptureMaximumTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{	
		systemInMock.provideLines(operand_max);
	    capture = new CaptureRPN();
	    capture.capture();
	}
	
	/**
	 * Clean the dynamic allocations
	 */
	@After
	public void clean()
	{
		motorMaxMin = null;
		capture = null;
	}
	
}
