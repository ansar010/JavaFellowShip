/*********************************************************************************
 * purpose : Program to find square root of given number by using newton's method
 * 
 * @author Ansar
 * @version 1.2
 * @since 28/12/2018
 *********************************************************************************/
package com.fellowship.algorithms;

import com.fellowship.utility.Utility;

public class NewtonSqrtRunner
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the c value : ");
		int c =Utility.getInt();
		//Calling method to get square root 
		double result = Utility.newtonSqrt(c);
		System.out.println(result);
	}
}
