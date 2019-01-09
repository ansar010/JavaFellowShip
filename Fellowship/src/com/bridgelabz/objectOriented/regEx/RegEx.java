package com.bridgelabz.objectOriented.regEx;

import java.time.LocalDate;

import com.bridgelabz.model.UserDetails;
import com.fellowship.utility.Utility;

public class RegEx {
	public static void main(String args[])
	{
		Utility u=new Utility();

		UserDetails user=new UserDetails();
		System.out.println();

		//asking user to enter his data
		System.out.println("Enter FirstName:");
		user.setfName(Utility.getLine());
		System.out.println();

		System.out.println("Enter LastName:");
		user.setlName(Utility.getLine());
		System.out.println();

		System.out.println("Enter Mobile Number:");
		user.setmobileNo(Utility.getLine());
		System.out.println();	
		
		String message = u.getFile("message.txt");
		System.out.println(message);
		//Setting current date
		user.setdate(u.getFormattedDate(LocalDate.now()));
		System.out.println(u.replaceRegExString(user,u.getFile("message.txt")));	
	}
}
