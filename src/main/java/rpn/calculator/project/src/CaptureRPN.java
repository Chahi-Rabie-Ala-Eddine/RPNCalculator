package rpn.calculator.project.src;

import java.util.*;
import java.util.regex.Pattern;

import rpn.calculator.project.exc.*;

public class CaptureRPN 
{
	private Scanner m_input;
	private MotorRPN m_motor;
	private ArrayList<Object> list = new ArrayList<Object>();
	
	public CaptureRPN()
	{
		m_input = new Scanner(System.in);
		m_motor = new MotorRPN();
	}
	
	public MotorRPN getMotor()
	{
		return this.m_motor;
	}
	
	private boolean nextDouble()
	{	
		if (this.m_input.hasNextDouble()) 
	        return true;
		
		return false;
	}
	
	private static boolean isCharacter(char character)
	{
		return (character >= 48 && character <= 57); 
	}
	
	private boolean isDouble(String str)
	{
		String regexDecimal = "^[-+]?\\d*\\.\\d+$";
		String regexInteger = "^[-+]?\\d+$";
		String regexDouble = regexDecimal + "|" + regexInteger;

		if(Pattern.matches(regexDouble, str))
			return true;
		
		return false;
	}
	
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
	
	private Operation attributeOperation(String str)
	{
		Object temp = isOperation(str);
		
		if(temp.toString().equalsIgnoreCase("false"))
			return null;
		
		else
			 return (Operation) temp;
	}
	
	private String postfixNotation()
	{
		String m_postfixeNotation = "";
		
		for(Object operand : this.list)
		{
			m_postfixeNotation+= operand + " ";
		}
		
		return m_postfixeNotation;
	}
	
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
	
	public void capture() throws NumberFormatException, AbsoluteMinMaxValuesException, DivideByZeroException, StackSizeException, CaptureInException
	{
		System.out.println("🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶RPN CALCULATOR ON🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷");
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
					System.out.println("🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷 RPN CALCULATOR OFF !🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷🔶🔷\n");
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
