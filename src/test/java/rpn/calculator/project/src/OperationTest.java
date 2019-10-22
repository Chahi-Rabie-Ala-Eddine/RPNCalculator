package rpn.calculator.project.src;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.calculator.project.exc.DivideByZeroException;

public class OperationTest {
	
	private Operation operation;
	private boolean test = false;
	private final static double rightOperand = 4;
	private final static double leftOperand = 2;
	private final static double zeroOperand = 0;
	
	
	@Test
	public void addTest() 
		throws DivideByZeroException
	{
		operation = Operation.PLUS;
		test=(operation.eval(rightOperand,leftOperand) == 6.0);
		assertEquals(test,true);
	}
	
	@Test
	public void substractTest() 
		throws DivideByZeroException
	{
		operation = Operation.MOINS;
		test = (operation.eval(rightOperand,leftOperand) == 2.0);
		assertEquals(test,true);
	}

	@Test
	public void multiplyTest() 
		throws DivideByZeroException
	{
		operation = Operation.MULT;
		test = (operation.eval(rightOperand,leftOperand) == 8.0);
		assertEquals(test,true);
	}
	
	@Test
	public void divideTest() 
		throws DivideByZeroException
	{
		operation = Operation.DIV;
		test = (operation.eval(rightOperand,leftOperand) == 2.0);
		assertEquals(test,true);
	}

	@Test(expected = DivideByZeroException.class)
	public void testDivParZero() 
		throws DivideByZeroException 
	{
		operation = Operation.DIV;
		operation.eval(rightOperand,zeroOperand);
	}	

}
