package rpn.calculator.project.exc;

import rpn.calculator.project.src.MotorRPN;

/**
 * This this exception is thrown when the limits of this calculator are exceeded
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
@SuppressWarnings("serial")

public class AbsoluteMinMaxValuesException extends Exception
{
	
	/**
	 * An attribute motor which will be used to get maximum and minimum values throw its getters
	 */
	MotorRPN motor = new MotorRPN();
	
	/**
	 * CaptureRPN Constructor
	 */
	public AbsoluteMinMaxValuesException()
	{
	    System.err.println("\n\n       ⚠️ U are outside the limits of this calculator ⚠️\n                        🔵MAX =  " + motor.getMaxValue() + "\n                        🔴MIN = " + motor.getMinValue());                        
	}
	
}
