package com.fellowship.dataStructure.binaryTree;

public class Factorial {
	static long catalanNumber(int number)
	{
		long x=2*number;
		x=factorial(x);

		long y=number+1;
		y=factorial(y);

		long z=factorial(number);

		long possibleValue=x/(y*z);
		return possibleValue;
	}

	private static long factorial(long y) {
		long fact=1;

		for(long i=1;i<=y;i++)
		{
			fact=fact*i;
		}
		return fact;
	}
}
