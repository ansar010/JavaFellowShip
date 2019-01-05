/*************************************************************************
 * purpose : program to check parenthesis balanced or not
 * 
 * @author Ansar
 * @version 1.2
 * @since 5/01/2019
 * 
 *************************************************************************/
package com.fellowship.dataStructure.stack;

import com.fellowship.utility.Utility;

public class StackRunner
{	/*
	 * written main method to run the is paranthesis balance or not
	 */ 
	public static void main(String[] args) 
	{
		Stack stack = new Stack();	
		
		System.out.println("Enter the Expression to check the parenthesis balanced or not");
		String expression = Utility.getLine();

		boolean result=stack.isParenthesisBalance(expression);
		
		if(result==true)
		{
			System.out.println("The given Expression : "+expression+" is balance");
		}
		else
			System.out.println("Given expression : "+expression+" is not balance");
	
	}
}