package com.bridgelabz.objectOriented;

import java.time.LocalDate;

import com.bridgelabz.model.UserDetails;

public class RegExMain
{
	public static void main(String[] args) {


		UtilityOops u=new UtilityOops();
		UserDetails user=new UserDetails();


		System.out.print("Enter the first name : ");
		user.setFirstName(u.getWord());
		

		System.out.print("Enter the last name : ");
		user.setLastName(u.getWord());


		System.out.print("Enter the mobile num : ");
		user.setMobileNo(u.getWord());

		user.setDate(LocalDate.now());
		
		System.out.println();
		System.out.println(u.replaceUserdata(user,u.readFile("/home/admin1/Desktop/OOPs/Message.txt")));
	}
}