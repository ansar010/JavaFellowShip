package com.bridgelabz.objectOriented;

import java.time.LocalDate;

public class UserDetailsRegEx 
{
	private String name;
	private String full_name;
	private String mobile_no;
	private LocalDate date;//used java8 date class

//	public UserDetailsRegEx()
//	{
//		
//	}
	public String getName() {
		return name;
	}
	public String getFull_name() {
		return full_name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getDate() {
		return String.valueOf(date);
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}


}
