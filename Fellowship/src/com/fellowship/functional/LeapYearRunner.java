/**********************************************************
 * purpose : To check the given year is leap year or not 
 * 
 * @author Ansar
 * @version 1.2
 * @since 15/12/2018
 **********************************************************/
package com.fellowship.functional;

import com.fellowship.utility.Utility;

public class LeapYearRunner 
{	/*
	 *The main function written to run the isLeapYear
	 */
	public static void main(String[] args)
	{
		System.out.println("Enter the Year to Check whether it is Leap Year or Not..!");
		int year = Utility.getInt();
		
		// length variable hold the length of integer year
		int length = Integer.toString(year).length();
		
		while(length<4&&length>4)
		{
			System.err.println("Enter 4 Digit year");
			year=Utility.getInt();
		}
		 //calling method to check leap year
		if(Utility.isLeapYear(year))
		{
		System.out.println(year+" is a leap year.");
		}
		else
		{
			System.out.println(year+" is not a leap year.");

		}

	}
}
