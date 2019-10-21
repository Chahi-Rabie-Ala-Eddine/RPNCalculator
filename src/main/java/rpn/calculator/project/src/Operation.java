package rpn.calculator.project.src;

import rpn.calculator.project.exc.*;

public enum Operation 
{
	PLUS ('+') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand + left_operand);
		}
	},
	MOINS ('-') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand - left_operand);
		}
	},
	MULT ('*') 
	{
		@Override
		public double eval(double right_operand , double left_operand) 
		{
			return (right_operand * left_operand);
		}
	},
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
	
	private char m_symbole;

    Operation(char symbol)
    {
    	this.m_symbole = symbol;
    }
    
    public char getSymbol()
    {
    	return this.m_symbole;
    }
    
	public abstract double eval(double a, double b) throws DivideByZeroException;
	
	public String toString()
	{
		return String.valueOf(this.m_symbole);
	}
	
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
