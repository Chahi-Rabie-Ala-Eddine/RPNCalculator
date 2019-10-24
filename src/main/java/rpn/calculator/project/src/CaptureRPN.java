package rpn.calculator.project.src;

import java.util.*;
import java.util.regex.Pattern;

import rpn.calculator.project.exc.*;

/**
 * This class manages user's input keyboards
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public class CaptureRPN 
{
	/**
	 * The scanner that will be used to manage inputs
	 */
	private Scanner m_input;
	
	/**
	 * The MotorRPN that will be used to manage operations
	 */
	private MotorRPN m_motor;
	
	/**
	 * A list which will be used to print arithmetic expressions
	 */
	private ArrayList<Object> list = new ArrayList<Object>();
	
	/**
	 * CaptureRPN Constructor
	 */
	public CaptureRPN()
	{
		m_input = new Scanner(System.in);
		m_motor = new MotorRPN();
	}
	
	/**
	 * CaptureRPN motor's getter
	 */
	public MotorRPN getMotor()
	{
		return this.m_motor;
	}
	
	/**
	 * Test if the next input is a double or not
	 * @return True or False
	 */
	private boolean nextDouble()
	{	
		if (this.m_input.hasNextDouble()) 
	        return true;
		
		return false;
	}
	
	/**
	 * Test if a input is a character or not 
	 * @param character
	 * @return True or False
	 */
	private static boolean isCharacter(char character)
	{
		return (character >= 48 && character <= 57); 
	}
	
	/**
	 * Test if a input is a double or not
	 * @param str
	 * @return True or False
	 */
	private boolean isDouble(String str)
	{
		String regexDecimal = "^[-+]?\\d*\\.\\d+$";
		String regexInteger = "^[-+]?\\d+$";
		String regexDouble = regexDecimal + "|" + regexInteger;

		if(Pattern.matches(regexDouble, str))
			return true;
		
		return false;
	}
	
	/**
	 * Test if a string is an operation or not
	 * @param str
	 * @return Operation or False
	 */
	private Object isOperation(String str)
	{
		for(Operation op : Operation.values())
		{
			if(str.equals(String.valueOf(op.getSymbol())))
			{
				return op;
			}
		}
		
		return false;
	}
	
	/**
	 * Attribute operation as soon as the input is an appropriate operation
	 * @param str
	 * @return Operation or null
	 */
	private Operation attributeOperation(String str)
	{
		Object temp = isOperation(str);
		
		if(temp.toString().equalsIgnoreCase("false"))
			return null;
		
		else
			 return (Operation) temp;
	}
	
	/**
	 * Print the postfix notation of the actual arithmetic expression
	 * @return String
	 */
	private String postfixNotation()
	{
		String m_postfixeNotation = "";
		
		for(Object operand : this.list)
		{
			m_postfixeNotation+= operand + " ";
		}
		
		return m_postfixeNotation;
	}
	
	/**
	 * Print the infix notation of the actual arithmetic expression
	 * @param str
	 * @return String
	 */
	static String infixNotation(String str) 
	{ 
	    Stack<String> stack = new Stack<String>(); 
	  
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        if (isCharacter(str.charAt(i))) 
	        	stack.push(" " + str.charAt(i) + " ");
	  
	        else
	        { 
	            String op1 = stack.peek(); 
	            stack.pop(); 
	            String op2 = stack.peek(); 
	            stack.pop(); 
	            stack.push(" ( " + op2 + str.charAt(i) + op1 + " ) "); 
	        } 
	    } 

	    return stack.peek(); 
	} 
	
	/**
	 * The main method of this class, it manage the capture of the user
	 * @throws NumberFormatException
	 * @throws AbsoluteMinMaxValuesException
	 * @throws DivideByZeroException
	 * @throws StackSizeException
	 * @throws CaptureInException
	 */
	public void capture() throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException
	{
		System.out.println("🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶RPN CALCULATOR 💡🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷");
		System.out.println("\n       		 ✍️ 🔢 or ➕➖➗✖️ or exit 🤓 ");
		String str = "";
		
		do
		{
			if(this.nextDouble())
			{
				str = this.m_input.next();	
				this.list.add(str);		
				this.m_motor.saveOperand(Double.valueOf(str));	
				System.out.println(m_motor.showOperand());
			}
			else
			{
				str = this.m_input.next();
				
				if(isDouble(str))
				{
					this.list.add(str);
					this.m_motor.saveOperand(Double.valueOf(str));
					System.out.println(m_motor.showOperand());
				}
				else if(attributeOperation(str) != null)
				{
					this.list.add(str);
					this.m_motor.applicateOperation(attributeOperation(str));
					System.out.println(m_motor.showOperand());
				}
				else if (str.equals("exit") || str.equals("EXIT"))
				{ 
					System.out.println("🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶RPN CALCULATOR 📴🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n");
					System.err.println("\n                          RPN OFF 🛑\n             🙍‍♂️Developped by CHAHI Rabie Ala Eddine\n           	   💻M1 Computer science UVSQ\n		     📬rabie_chahi@yahoo.fr\n                   ©️2019 All rights reserved");
					break;
				}
				else if(str.equalsIgnoreCase("\r"))
				{ 
					System.out.println("You put a return line , RPN stopped !");
					continue;
				}
				else
				{
					throw new CaptureInException();
				}
			}
			
			System.out.println("\n" + "🔵 Postfix Notation [ " +  postfixNotation() + "]");
			System.out.println("\n" + "🔴 Infix Notation [ " +  infixNotation(postfixNotation().replaceAll("\\s+","")) + " ]");
			System.out.println("\n⚫ Result [" + this.m_motor.getStack().lastElement() + "]\n");
			System.out.println("_______________________________________________________________\n\n       		 ✍️ 🔢 or ➕➖➗✖️ or exit to 🤓");
			
		}while(this.m_input.hasNext());
		
		this.m_input.close();
				
	}
}
