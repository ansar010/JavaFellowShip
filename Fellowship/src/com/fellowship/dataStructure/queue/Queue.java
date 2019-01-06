package com.fellowship.dataStructure.queue;

import com.fellowship.utility.Utility;

public class Queue 
{
	int front=-1;//point front position
	int rear=-1;//point rear position
	int capacity=0;
	Object value[];//an Array of data

	public Queue(int cap)
	{
		this.value=new Object[cap];
		this.capacity=cap;
	}
	//=================================cashCounter=============================

	public void cashCounter(int numOfperson) 
	{	
		int temp=numOfperson;
		int choice=0;//to store user choice 
		//System.out.println(temp);
		//loop to add people in queue
		for(int i=0;i<temp;i++)
		{
			String name = Utility.getWord();
			//System.out.println(i+ " "+temp);
			enqueue(name);//calling enqueue to add persons 
		}

		do 
		{
			System.out.println("---------bank cash counter-------");
			System.out.println("1.Deposit \n2.Withdraw \n3.Number of people \n4.Exit");
			System.out.print("Enter your choice : ");

			choice = Utility.getInt();

			switch(choice)
			{
			case 1:
				System.out.print("Enter the amount you want to Deposit : ");
				int depositAmount = Utility.getInt();

				bank(depositAmount,choice);
				numOfperson--;
				dequeue();
				break;

			case 2:
				System.out.print("Enter the amount you want to Withdraw : ");
				int withdrawAmount = Utility.getInt();

				if(bank(withdrawAmount, choice)==true)
				{
					numOfperson--;
					dequeue();
				}
				break;


			case 3:
				System.out.println("no of people in queue is "+size()); 			
				break;
			case 4:
				System.exit(0);
			}
		}while(numOfperson>0);

	}
	//=================================size====================================
	public Object size() 
	{
		if(rear==-1 && front == -1) 
			return 0;

		if(rear>-1 && front==0)
			return rear+1;

		if(front>-1 && rear >-1)
		{
			return (rear-front)+1;
		}

		if(front==rear)
		{
			return 0;
		}

		return true;	

	}
	public Object dequeue() 
	{
		if(rear==front || rear==-1)
		{
			System.out.println("Queue underflow..!");
			return null;
		}
		else
		{
			return value[++front];
		}
	}

	long bankBalance=2000;//Initial bank balance
	private boolean bank(int amount, int choice)
	{
		if(choice==1)
		{
			bankBalance=bankBalance+amount;
			System.out.println("Bank Balance after deposit : "+bankBalance);
			return true;
		}
		else
		{
			if(amount>bankBalance)
			{
				System.out.println("Insufficient balance..!");
				return false;
			}
			else
			{			
				bankBalance=bankBalance-amount;
				System.out.print("Bank Balance  after withdraw : "+bankBalance);
				return true;
			}


		}
	}
	//=================================enqueue=================================
	public void enqueue(Object data) 
	{
		if(rear==capacity)
		{
			System.out.println("Queue overflowed..!");
		}
		//	System.out.println(value.length);
		value[++rear]=data;

		//		if(front==-1)
		//			front=0;
	}

	//=================================override toString to see content instead of address=========
	@Override
	public String toString() {
		for(int i=0;i<=rear;i++)
		{
			System.out.println(value[i]);
		}
		return "";
	}
}
