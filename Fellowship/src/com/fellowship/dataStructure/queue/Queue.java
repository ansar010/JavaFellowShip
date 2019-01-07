/*************************************************************************
 * purpose : program to create queue and it's functionalities
 * 
 * @author Ansar
 * @version 1.2
 * @since 7/01/2019
 * 
 *************************************************************************/
package com.fellowship.dataStructure.queue;

import com.fellowship.utility.Utility;

public class Queue 
{
	int front=-1;//point front position
	int rear=-1;//point rear position
	int capacity=0;
	Object value[];//an Array of data

	//constructor for create queue and initialize  queue's members
	public Queue(int cap)
	{
		this.value=new Object[cap];
		this.capacity=cap;
	}
	//=================================cashCounter=============================
	/**
	 * purpose : Method for cashCounter to maintain bank balance 
	 * @param numOfperson takes persons to add in queue
	 */
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

		//loop to get user choice 
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
				//calling method deposit amount and check balance 
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

	//=================================enqueue=================================
	/**
	 * purpose : Enqueue method to add users in queue
	 * @param data takes from user
	 */
	public void enqueue(Object data) 
	{
		if(rear==capacity)
		{
			System.out.println("Queue overflowed..!");
		}
		//	System.out.println(value.length);
		value[++rear]=data;
	}

	//=================================dequeue=================================
	/**
	 * purpose : Dequeue method to remove persons from queue
	 * @return removed data
	 */
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

	//=================================bank====================================

	long bankBalance=2000;//Initial bank balance
	/**
	 * purpose : bank method to perform banking operations
	 * @param amount takes from user
	 * @param choice of deposit or withdraw
	 * @return true if user done baking else false
	 */
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


	//=================================size====================================

	/**
	 * purpose : To calculate the size of queue
	 * @return size of queue
	 */
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

	//=================================override toString to see content instead of address=========
	/**
	 * purpose : overriding toString method to display the content
	 */
	@Override
	public String toString() {
		for(int i=0;i<=rear;i++)
		{
			System.out.println(value[i]);
		}
		return "";
	}
}
