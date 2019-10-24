package rpn.calculator.project.src;

import java.util.*;

import rpn.calculator.project.exc.*;

/**
 * This class manages the arithmetic expressions
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public class MotorRPN 
{
	/**
	 * The scanner that will be used to manage inputs
	 */
	private Stack<Double> stack;
	
	/**
	 * The Maximum and the Minimum values accepted by this calculator
	 */
	private static final double MAX_VALUE = 99999, MIN_VALUE = -99999;
	
	/**
	 * CaptureRPN Constructor
	 */
	public MotorRPN()
	{
		this.stack = new Stack<Double>();
	}
	
	/**
	 * MotorRPN stack's getter
	 */
	public Stack<Double> getStack()
	{
		return this.stack;
	}
	
	/**
	 * MotorRPN minimum value's getter
	 */
	public double getMaxValue()
	{
		return MotorRPN.MAX_VALUE;
	}
	
	/**
	 * MotorRPN maximum value's getter
	 */
	public double getMinValue()
	{
		return MotorRPN.MIN_VALUE;
	}
		
	/**
	 * Push the operand in the stack until it is between Max and Min value
	 * @param operand
	 * @throws AbsoluteMinMaxValuesException
	 */
	public void saveOperand(double operand)
		throws AbsoluteMinMaxValuesException
	{
		if(operand > MAX_VALUE || operand < MIN_VALUE)
			throw new AbsoluteMinMaxValuesException();
		
		this.stack.push(operand);
	}
	
	/**
	 * manage an operation to the two firsts operands in the stack
	 * @param opr
	 * @throws AbsoluteMinMaxValuesException
	 * @throws DivideByZeroException
	 * @throws StackSizeException
	 */
	public void applicateOperation(Operation opr)
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException
	{
		if(this.stack.size() < 2)
			throw new StackSizeException();
			
		double left_operand = stack.pop(),right_operand = stack.pop();
			
		saveOperand(opr.eval(right_operand, left_operand));
	}
	
	/**
	 * Show operands of the actual stack
	 * @return String
	 */
	public String showOperand()
	{	
		Iterator<Double> iterator = this.stack.iterator();
		ArrayList<Double> list = new ArrayList<Double>();
		String stack = "";
		
		while (iterator.hasNext()) 
		{
			  list.add(iterator.next()); 
		}
		
		Collections.reverse(list);

		for (Double operand : list) 
		{
		    stack+= "                           | " + operand + " |\n";
		}

		return stack + "\n                    📚 Stack : 📏Size[" + this.stack.size() + "]";	
	}
	
	/**
	 * Re-implementation of toString in order the describe the actual issue of the motor
	 * @return
	 */
	public String toString()
	{
		return "Motor RPN description :\n\n     Actual Stack \n\n" + this.showOperand() + "\nMaximum value supported : " + MAX_VALUE + "\nMinimmum value supported : " + MIN_VALUE;
	}
}
