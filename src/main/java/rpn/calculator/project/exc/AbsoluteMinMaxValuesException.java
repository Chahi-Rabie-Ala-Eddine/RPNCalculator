/**
 * 
 */
package rpn.calculator.project.exc;

import rpn.calculator.project.src.MotorRPN;

/**
 * @author aladin
 *
 */
@SuppressWarnings("serial")

public class AbsoluteMinMaxValuesException extends Exception
{
	MotorRPN motor = new MotorRPN();
	
	public AbsoluteMinMaxValuesException()
	{
	    System.err.println("\n\n       ⚠️ U are outside the limits of this calculator ⚠️\n                        🔵MAX =  " + motor.getMaxValue() + "\n                        🔴MIN = " + motor.getMinValue());                        
	}
	
}
