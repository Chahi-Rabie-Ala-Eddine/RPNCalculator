package rpn.calculator.project.src;

import java.util.*;

import rpn.calculator.project.exc.*;

public class MotorRPN 
{
	private Stack<Double> stack;
	private static final double MAX_VALUE = 99999, MIN_VALUE = -99999;
		
	public MotorRPN()
	{
		this.stack = new Stack<Double> ();
	}
	
	public Stack<Double> getStack()
	{
		return this.stack;
	}
	
	public double getMaxValue()
	{
		return MotorRPN.MAX_VALUE;
	}
	
	public double getMinValue()
	{
		return MotorRPN.MIN_VALUE;
	}
	
	public void saveOperand(double operand)
		throws AbsoluteMinMaxValuesException
	{
		if(operand > MAX_VALUE || operand < MIN_VALUE)
			throw new AbsoluteMinMaxValuesException();
		
		this.stack.push(operand);
	}
	
	public void applicateOperation(Operation opr)
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException
	{
		if(this.stack.size() < 2)
			throw new StackSizeException();
			
		double left_operand = stack.pop(),right_operand = stack.pop();
			
		saveOperand(opr.eval(right_operand, left_operand));
	}
	
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
	
	public String toString()
	{
		return "Motor RPN description :\n\n     Actual Stack \n\n" + this.showOperand() + "\nMaximum value supported : " + MAX_VALUE + "\nMinimmum value supported : " + MIN_VALUE;
	}
}
