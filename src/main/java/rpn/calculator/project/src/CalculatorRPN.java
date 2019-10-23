package rpn.calculator.project.src;

import rpn.calculator.project.exc.*;

public enum CalculatorRPN 
{
	CALCULATOR;
	
	public void start() 
		throws CaptureInException, StackSizeException, AbsoluteMinMaxValuesException, DivideByZeroException
	{
		try 
		{
			CaptureRPN cptrpn = new CaptureRPN();
			cptrpn.capture();
		}
		
		catch(CaptureInException exp) {}
		
		catch(StackSizeException exp) {}
		
		catch(AbsoluteMinMaxValuesException exp) {}
		
		catch(DivideByZeroException exp) {}
		
	}
	
	public static void main(String[] args) 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		CALCULATOR.start();
	}

}
