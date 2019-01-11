package Stock;

import java.util.Scanner;

public class StockReport1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		do
		{
			System.out.println("1.u want to entry \n2.buy share \n3.sell share \n4.print Stock report \n5.print customer detail \n6.print transaction details \n7.exit");
			System.out.println("enter ur choice");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("create new account for customer");
				StockAccount acc=new StockAccount();

				break;
			case 2:
				System.out.println("enter the amount of share");
				int share=scanner.nextInt();
				System.out.println("enter the symbol");
				String symbol=scanner.next();
				StockAccount.buy(share,symbol);
				break;
			case 4:
				System.out.println("stock details");
				StockAccount.printStockReport();
				break;
			case 5:
				System.out.println("customer details");
				StockAccount.printCustomerDetail();
				break;
			case 7: 
				System.exit(0);		
			}
		}while(choice!=7);
	}
}
