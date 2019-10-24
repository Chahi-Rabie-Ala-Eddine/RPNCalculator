package rpn.calculator.project.src;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import rpn.calculator.project.exc.*;

/**
 * This test class manages tests of the MotorRPNTest class
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public class MotorRPNTest 
{
	private MotorRPN motor;
	private boolean test = false;
	private final static double operand = 4;
	private final static double rightOperand = 5;
	private final static double leftOperand = 2;
	private final static double zeroOperand = 0;

	/**
	 * Initialization of the attributes
	 */
	@Before
	public void init() 
	{
		motor = new MotorRPN();
	}
	
	/**
	 * Test if the stack is empty
	 */
	@Test
	public void isEmptyStackTest() 
	{
		assertEquals(motor.getStack().empty(),true);
	}

	/**
	 * Test if the stack if full
	 */
	@Test
	public void isFullStackTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(operand);
		assertEquals(motor.getStack().empty(),false);
	}
	
	/**
	 * Test if the stack contain the element pushed
	 */
	@Test
	public void isOperandInStackTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(operand);
		test = (motor.getStack().pop() == operand);
		assertEquals(test,true);
	}
	
	/**
	 * Test if the AbsoluteMinMaxValuesException is thrown by pushing 
	 * a number bigger than Max value
	 */
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void AbsoluteMinValuesExceptionTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(motor.getMaxValue() + Double.MAX_VALUE);
	}
	
	/**
	 * Test if the AbsoluteMinMaxValuesException is thrown by pushing 
	 * a number smaller than Min value
	 */
	@Test (expected = AbsoluteMinMaxValuesException.class)
	public void AbsoluteMaxValuesExceptionTest() 
		throws AbsoluteMinMaxValuesException
	{
		motor.saveOperand(motor.getMaxValue() - Double.MAX_VALUE);
	}
	
	/**
	 * Test if the the result of the addition is rightly pushed
	 */
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
	
	/**
	 * Test if the the result of the subtraction is rightly pushed
	 */
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
	
	/**
	 * Test if the the result of the multiplication is rightly pushed
	 */
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
	
	/**
	 * Test if the the result of the division is rightly pushed
	 */
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
	
	/**
	 * Test if the DivideByZeroException is thrown by pushing a division by zero
	 */
	@Test(expected = DivideByZeroException.class)
	public void divideByZeroTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.saveOperand(zeroOperand);
		motor.applicateOperation(Operation.DIV);
	}

	/**
	 * Test if the StackSizeException is thrown by pushing an addition with no operands
	 */
	@Test(expected = StackSizeException.class)
	public void stackEmptyAddTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.PLUS);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a subtraction with no operands
	 */
	@Test(expected = StackSizeException.class)
	public void stackEmptySubstractTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.MOINS);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a multiplication with no operands
	 */
	@Test(expected = StackSizeException.class)
	public void stackEmptyMultiplyTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.MULT);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a division with no operands
	 */
	@Test(expected = StackSizeException.class)
	public void stackEmptyDivideTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.applicateOperation(Operation.DIV);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing an addition with only one element
	 */
	@Test(expected = StackSizeException.class)
	public void onElementAddOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.PLUS);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a subtraction with only one element
	 */
	@Test(expected = StackSizeException.class)
	public void oneElementSubstractOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.MOINS);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a multiplication with only one element
	 */
	@Test(expected = StackSizeException.class)
	public void oneElementMultiplyOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.MULT);
	}
	
	/**
	 * Test if the StackSizeException is thrown by pushing a division with only one element
	 */
	@Test(expected = StackSizeException.class)
	public void oneElementDivideOperationPossibleTest() 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException 
	{
		motor.saveOperand(operand);
		motor.applicateOperation(Operation.DIV);
	}
	
	/**
	 * Clean the dynamic allocations
	 */
	@After
	public void clean()
	{
		motor = null;
	}
}
