/*************************************************************************
 * purpose : program print calendar
 * 
 * @author Ansar
 * @version 1.2
 * @since 7/01/2019
 * 
 *************************************************************************/
package com.fellowship.dataStructure.calendar;

import com.fellowship.utility.Utility;

public class Calendar
{
	public static void main(String[] args) 
	{
		int month = Integer.parseInt(args[0]);
		int year  = Integer.parseInt(args[1]);
		System.out.println("Moth and Year Passed in command line Argument : Month->"+month+" Year->"+year);
		System.out.println();
		//calling method to get Day code
		int startingDay = Utility.dayOfWeek(1, month, year);
		
		//calling method to print calendar
		Utility.printCalendar(startingDay,month,year);
		
	}
}
