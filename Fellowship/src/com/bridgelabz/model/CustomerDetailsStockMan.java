/******************************************************************************
 * purpose : POJO/model class for customer details.
 * 
 * @author Ansar
 * @version 1.2
 * @since 14/01/2018
 ******************************************************************************/ 
package com.bridgelabz.model;

public class CustomerDetailsStockMan
{
	private String name;
	private int id;
	private String mobile_num;
	
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
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	} 
}
