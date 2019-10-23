package rpn.calculator.project.src;

import static org.junit.Assert.*;

import org.junit.Test;

import rpn.calculator.project.exc.DivideByZeroException;

public class OperationTest {
	
	private Operation operation;
	private boolean test = false;
	private final static double rightOperand = 5;
	private final static double leftOperand = 2;
	private final static double zeroOperand = 0;
	
	
	@Test
	public void addOperationTest() 
		throws DivideByZeroException
	{
		operation = Operation.PLUS;
		test=(operation.eval(rightOperand,leftOperand) == 7.0);
		assertEquals(test,true);
	}
	
	@Test
	public void substractOperationTest() 
		throws DivideByZeroException
	{
		operation = Operation.MOINS;
		test = (operation.eval(rightOperand,leftOperand) == 3.0);
		assertEquals(test,true);
	}

	@Test
	public void multiplyOperationTest() 
		throws DivideByZeroException
	{
		operation = Operation.MULT;
		test = (operation.eval(rightOperand,leftOperand) == 10.0);
		assertEquals(test,true);
	}
	
	@Test
	public void divideOperationTest() 
		throws DivideByZeroException
	{
		operation = Operation.DIV;
		test = (operation.eval(rightOperand,leftOperand) == 2.5);
		assertEquals(test,true);
	}

	@Test(expected = DivideByZeroException.class)
	public void DivideByZeroOperationTest() 
		throws DivideByZeroException 
	{
		operation = Operation.DIV;
		operation.eval(rightOperand,zeroOperand);
	}	
}
