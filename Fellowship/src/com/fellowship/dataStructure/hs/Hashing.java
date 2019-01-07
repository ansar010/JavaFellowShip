package com.fellowship.dataStructure.hs;

public class Hashing 
{
	public static void main(String args[])
	{
		Integer array[] = {33,44,55,64,34,23,22,121,11,21,14};
		OrderedList<Integer> arr[] =new OrderedList[array.length];
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=new OrderedList<Integer>();
		}

		for(int i=0;i<arr.length;i++)
		{
			index = array[i]%array.length;
			arr[index].add(array[i]);
		}

		for(int i=0;i<arr.length;i++)
		{
			System.out.print(i+"");
			for(int j=0;j<arr[i].size();j++)
			{   System.out.print("--->");
			System.out.print(arr[i].get(j+1)+" ");
			}
			System.out.println();
		}

	}
}
