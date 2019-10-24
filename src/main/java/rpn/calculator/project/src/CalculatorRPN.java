package rpn.calculator.project.src;

import rpn.calculator.project.exc.*;

/**
 * This enumeration this enumeration launches the entire program
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public enum CalculatorRPN 
{
	/**
	 * The enumeration Calculator which will be used to start the program
	 */
	CALCULATOR;
	
	
	/**
	 * This method is the main one in the program, it manages the start point
	 * @throws CaptureInException
	 * @throws StackSizeException
	 * @throws AbsoluteMinMaxValuesException
	 * @throws DivideByZeroException
	 */
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
	
	/**
	 * The main
	 * @param args
	 * @throws AbsoluteMinMaxValuesException
	 * @throws DivideByZeroException
	 * @throws StackSizeException
	 * @throws CaptureInException
	 */
	public static void main(String[] args) 
		throws AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException 
	{
		CALCULATOR.start();
	}

}
