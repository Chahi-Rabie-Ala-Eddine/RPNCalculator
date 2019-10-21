/**
 * 
 */
package rpn.calculator.project.exc;

/**
 * @author aladin
 *
 */
@SuppressWarnings("serial")

public class AbsoluteMinMaxValuesException extends Exception
{
	public AbsoluteMinMaxValuesException()
	{
	    System.out.println("U are outside the limits of this calculator 😟 !");
	}  
}
