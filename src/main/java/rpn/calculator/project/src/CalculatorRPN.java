package rpn.calculator.project.src;

import rpn.calculator.project.exc.*;

public enum CalculatorRPN 
{
	CALCULATOR;
	
	public static void main(String[] args) 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		CaptureRPN rpn = new CaptureRPN();
		rpn.capture();
	}
}
