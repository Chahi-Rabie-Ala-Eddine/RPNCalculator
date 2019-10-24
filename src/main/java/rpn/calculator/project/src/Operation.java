package rpn.calculator.project.src;

import rpn.calculator.project.exc.*;

/**
 * This enumeration manages the arithmetic operations + - * /
 * @author CHAHI Rabie Ala Eddine
 * @version 1.0
 */
public enum Operation 
{
	/**
	 * The enumeration plus
	 */
	PLUS ('+') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand + left_operand);
		}
	},
	
	/**
	 * The enumeration minus
	 */
	MOINS ('-') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand - left_operand);
		}
	},
	
	/**
	 * The enumeration times
	 */
	MULT ('*') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand * left_operand);
		}
	},
	
	/**
	 * The enumeration per
	 */
	DIV ('/') {
		@Override
		public double eval(double right_operand , double left_operand) 
				throws DivideByZeroException
		{
			if(left_operand == 0)
				throw new DivideByZeroException();
			
			return (right_operand / left_operand);
		}
	};
	
	/**
	 * The character that will be used to describe operations
	 */
	private char m_symbole;

	/**
	 * Operation Constructor
	 */
    Operation(char symbol)
    {
    	this.m_symbole = symbol;
    }
    
    /**
	 * Operation's symbol getter
	 */
    public char getSymbol()
    {
    	return this.m_symbole;
    }
    
	/**
	 * Abstract method re-implemented in every single enumeration type in order to evaluate the result of the operation
	 * @param a
	 * @param b
	 * @return double
	 * @throws DivideByZeroException
	 */
	public abstract double eval(double a, double b) throws DivideByZeroException;
	
	/**
	 * Re-implementation of toString in order to print the operation sign
	 * @return
	 */
	public String toString()
	{
		return String.valueOf(this.m_symbole);
	}
	
	/**
	 * Another re-implementation of toString in order to describe the actual issue of the operation
	 * @return
	 */
	public String toString(double right_operand , double left_operand)
	{
		if(m_symbole == '+')
			return Double.toString(right_operand) + " " + m_symbole + " " + Double.toString(left_operand) + " = " + Double.toString(right_operand+left_operand);
		else if(m_symbole == '−')
			return Double.toString(right_operand) + " " + m_symbole + " " + Double.toString(left_operand) + " = " + Double.toString(right_operand-left_operand);
		else if(m_symbole == '×')
			return Double.toString(right_operand) + " " + m_symbole + " " + Double.toString(left_operand) + " = " + Double.toString(right_operand*left_operand);
		else if(m_symbole == '÷')
			return Double.toString(right_operand) + " " + m_symbole + " " + Double.toString(left_operand) + " = " + Double.toString(right_operand/left_operand);
		
		return "No operation in course";
	}

}
