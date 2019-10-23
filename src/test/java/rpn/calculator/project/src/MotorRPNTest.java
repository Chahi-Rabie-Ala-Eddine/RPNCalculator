package rpn.calculator.project.src;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import rpn.calculator.project.exc.*;

public class MotorRPNTest 
{
	private MotorRPN motor;
	private boolean test = false;
	private final static double operand = 4;
	private final static double rightOperand = 5;
	private final static double leftOperand = 2;
	private final static double zeroOperand = 0;

	@Before
	public void setUp() 
	{
		motor = new MotorRPN();
	}
	
	@Test
	public void isEmptyStackTest() 
	{
		assertEquals(motor.getStack().empty(),true);
	}

	@Test
	public void isFullStackTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(operand);
		assertEquals(motor.getStack().empty(),false);
	}
	
	@Test
	public void isOperandInStackTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(operand);
		test = (motor.getStack().pop() == operand);
		assertEquals(test,true);
	}
	
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void AbsoluteMinValuesExceptionTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(motor.getMaxValue() + Double.MAX_VALUE);
	}
	
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void AbsoluteMaxValuesExceptionTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(motor.getMaxValue() - Double.MAX_VALUE);
	}
	
	@Test
	public void addCalculTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(rightOperand);
		motor.saveOperand(leftOperand);
		motor.applicateOperation(Operation.PLUS);
		test = (motor.getStack().pop() == 7);
		assertEquals(test,true);
	}
	
	@Test
	public void substractCalculTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(rightOperand);
		motor.saveOperand(leftOperand);
		motor.applicateOperation(Operation.MOINS);
		test = (motor.getStack().pop() == 3);
		assertEquals(test,true);
	}
	
	@Test
	public void multiplyCalculTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(rightOperand);
		motor.saveOperand(leftOperand);
		motor.applicateOperation(Operation.MULT);
		test = (motor.getStack().pop() == 10);
		assertEquals(test,true);
	}
	
	@Test
	public void divideCalculTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(rightOperand);
		motor.saveOperand(leftOperand);
		motor.applicateOperation(Operation.DIV);
		test = (motor.getStack().pop() == 2.5);
		assertEquals(test,true);
	}
	
	@Test(expected = DivideByZeroException.class)
	public void divideByZeroTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.saveOperand(zeroOperand);
		motor.applicateOperation(Operation.DIV);
	}

	@Test(expected = StackSizeException.class)
	public void stackEmptyAddTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.PLUS);
	}
	
	@Test(expected = StackSizeException.class)
	public void stackEmptySubstractTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.MOINS);
	}
	
	@Test(expected = StackSizeException.class)
	public void stackEmptyMultiplyTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.MULT);
	}
	
	@Test(expected = StackSizeException.class)
	public void stackEmptyDivideTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.DIV);
	}
	
	@Test(expected = StackSizeException.class)
	public void onElementAddOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.PLUS);
	}
	
	@Test(expected = StackSizeException.class)
	public void oneElementSubstractOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.MOINS);
	}
	
	@Test(expected = StackSizeException.class)
	public void oneElementMultiplyOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.MULT);
	}
	
	@Test(expected = StackSizeException.class)
	public void oneElementDivideOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.DIV);
	}
	
}
