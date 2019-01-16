package com.bridgelabz.stockReport;

import com.bridgelabz.objectOriented.UtilityOops;

import stockManagement.StockDetail;

public class StockManagement 
{

	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) 
	{	
		System.out.println("Welcome to Stock management Application");
		System.out.println("=======================================\n");

		System.out.println("current stock details");
		System.out.println("=====================");

		PresentStock pStock = new PresentStock();

		//String jsonObj=UtilityOops.createStock();
		//UtilityOops.writeFile(jsonObj, "/home/admin1/Desktop/OOPs/StockManagement/presentStock.json");
		System.out.println("\n\n");

		int choice;
		Customer customer=null;;

		do
		{
			System.out.println("1.Add Customer \n2.StockAccount \n3.Print Stock Report \n4.Print Cusromer Details");
			System.out.println("Enter your choice");

			choice=UtilityOops.getInt();

			switch(choice)
			{
			case 1:
				System.out.println("ADD NEW CUSTOMER ");
				customer=new Customer();
				break;
			case 2:
				System.out.println("STOCK ACCOUNT");
				StockAccount stockAccount = new StockAccount();
				break;
			case 3:
				System.out.println();
				System.out.println("STOCK   DETAILS");
				StockDetail.printStockReport();
				System.out.println();
				break;		
			case 4:
				System.out.println();
				System.out.println("CUSTOMER   DETAILS");
				customer.printCustomerDetail();
				System.out.println();
				break;
			default:
				System.exit(0);
			}
		}while(choice!=5);
	}
}

