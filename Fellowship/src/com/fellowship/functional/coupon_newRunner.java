/********************************************************************
 * purpose : To generate random distinct coupon Numbers 
 * 
 * @author Ansar
 * @version 1.2
 * @since 18/12/2018
 ********************************************************************/
package com.fellowship.functional;

import com.fellowship.utility.Utility;

public class coupon_newRunner 
{	/*
	 *The main function written to run the coupon_new
	 */
	public static void main(String[] args) 
	{
		System.out.println("Enter the Number of coupons U want..!");
		System.out.println("Working");

		// n->to get numbers from user
		int n = Utility.getInt();

		// Calling method to generate distinct coupon number
		Utility.couponNew(n);
	}
}
