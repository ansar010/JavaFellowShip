package com.bridgelabz.objectOriented;

public class StockReport 
{
	public static void main(String[] args) 
	{

		System.out.println("Welcome to stock report program");
		System.out.println("===============================");

		String jsonObj=UtilityOops.createStock();
		UtilityOops.writeFile(jsonObj, "/home/admin1/Desktop/OOPs/StockReport.json");

	}
}
