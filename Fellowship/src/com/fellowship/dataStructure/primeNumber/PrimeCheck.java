package com.fellowship.dataStructure.primeNumber;

public class PrimeCheck {
	static int arr[]=new int[100],arr1[]=new int[200];
	static int check(int n)
	{
		int count=0;
		
		for (int i =(n-100); i <= n; i++)         
	    { 		  	  
	       int counter=0;	  
	       for(int num =i; num>=1; num--)
		  {
	          if(i%num==0)
		     {
			counter = counter + 1;
		     }
		  }
	       if(counter==2)
	       {
	       	  count++;
	       }
	}
		return count;
	}
	
	static int[] check1(int n)
	{
		int r=0;
		for (int i =(n-100); i <= n; i++)         
	    { 		  	  
	       int counter=0;	  
	       for(int num =i; num>=1; num--)
		  {
	          if(i%num==0)
		     {
			counter = counter + 1;
		     }
		  }
	       if(counter==2)
	       {
	       	  arr[r]=i;
	       	  //System.out.println(arr[r]);
	       	  r++;
	       }
	}
		return arr;
	}
	static int[] isPrime(int n)
	{
		
		int r=0;
		
		for (int i = 1; i <= n; i++)         
	    { 		  	  
	       int counter=0;	  
	       for(int num =i; num>=1; num--)
		  {
	          if(i%num==0)
		     {
			counter = counter + 1;
		     }
		  }
	       if(counter==2)
	       {
	    	   arr1[r]=i;
		       	  //System.out.println(arr[r]);
		       	  r++;
	       }
	      
	}
		return arr1;
}
}
