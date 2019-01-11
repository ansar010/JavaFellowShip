package stockManagement;

import java.util.Scanner;

public class StockReport 
{
	@SuppressWarnings({ "unused", "static-access", "resource" })
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("WELCOME   TO   STOCK   REPORT");
		int choice;
		CustomerInJson customer=null;;
		do
		{
			System.out.println("1.Add Customer \n2.StockAccount \n3.Print Stock Report \n4.Print Cusromer Details");
			System.out.println("enter ur choice");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("add new customer ");
				customer=new CustomerInJson();
				break;
			case 2:
				System.out.println("stock account");
				StockAccount account=new StockAccount();
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
