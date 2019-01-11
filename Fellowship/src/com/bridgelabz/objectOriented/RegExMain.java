package com.bridgelabz.objectOriented;

import com.bridgelabz.model.UserDetails;

public class RegExMain
{
	public static void main(String[] args) {


		UtilityOops u=new UtilityOops();
		UserDetails user=new UserDetails();


		System.out.println("enter the first name");
		user.setFirstName(u.inputString());


		System.out.println("enter the last name");
		user.setLastName(u.inputString());


		System.out.println("enter the mobile num");
		user.setMobileNo(u.inputString());

		System.out.println("enter the date");
		user.setDate(u.inputString());
	}
}