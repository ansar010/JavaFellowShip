
/******************************************************************************
 * purpose : POJO/model class for customer details.
 * 
 * @author Ansar
 * @version 1.2
 * @since 14/01/2018
 ******************************************************************************/ 
package com.bridgelabz.stock.model;

public class CustomerDetails
{
	private String name;
	private int id;
	private String num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnum() {
		return num;
	}
	public void setnum(String mobile_num) {
		this.num = mobile_num;
	} 
}
