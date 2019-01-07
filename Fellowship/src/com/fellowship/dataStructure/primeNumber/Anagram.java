package com.fellowship.dataStructure.primeNumber;

public class Anagram {
	static boolean isAnagram(int st1,int st2)
	{
		boolean b=check(st1,st2);

		return b;
	}

	private static boolean check(int st2,int st1)
	{
		int c[]=new int[10];
		int c1[]=new int[10];

		while(st1!=0)
		{
			int rem=st1%10;
			c[rem]++;
			st1=st1/10;
		}
		while(st2!=0)
		{
			int rem=st2%10;
			c1[rem]++;
			st2=st2/10;
		}
		for(int i=0;i<10;i++)
		{
			if(c[i]!=c1[i])
				return false;

		}
		return true;

	}
}
