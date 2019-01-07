package com.fellowship.dataStructure.binaryTree;

import com.fellowship.utility.Utility;

public class BinaryTree 
{
	public static void main(String[] args) 
	{
		System.out.println("enter the limits");
		int limit=Utility.getInt();
		int number[]=new int[limit];
		for(int i=0;i<limit;i++)
		{
			System.out.println("enter the number");
			number[i]=Utility.getInt();
			long x=Factorial.catalanNumber(number[i]);
			System.out.println("the possible number of "+number[i]+" node is "+x);
		}
	}
}
