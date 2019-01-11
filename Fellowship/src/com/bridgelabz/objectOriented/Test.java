package com.bridgelabz.objectOriented;


public class Test 
{
	public static void main(String[] args) 
	{
		String file=UtilityOops.readFile("/home/admin1/Desktop/fileTest.txt");
		System.out.println(file);
		UtilityOops.writeFile("Successfully Added", "/home/admin1/Desktop/fileTest.txt");

	}
}
