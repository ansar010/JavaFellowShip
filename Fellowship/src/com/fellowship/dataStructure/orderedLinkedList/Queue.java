package com.fellowship.dataStructure.orderedLinkedList;

public class Queue {
	static int rear=-1,front=-1;
	int cap=0;
	static int sum[]= {0,0,0};
	int balance=0;long bankBalance=2000;
	static Object obj[];
	public Queue(int scap) {
		this.cap=scap;
		obj=new Object[cap];
	}
	boolean bankAmount(int amount,int ch)
	{
		if(ch==1)
		{
			bankBalance=bankBalance+amount;
			System.out.println("bank balance is after deposit:"+bankBalance);
			return true;	
		}
		else
		{
			if(amount>bankBalance)
			{
				System.out.println("no amount in bank");
				System.out.println("The avail bal"+bankBalance+"try amnt with in bal");
				return false;
			}
			else
			{

				bankBalance=bankBalance-amount;
				System.out.println("bank balance is after previous withdraw:"+bankBalance);
				return true;
			}


		}
		//System.out.println(amount +" "+sum[person-1]);

	}

	public Boolean Enqueue(Object data) {

		if(rear==cap)
		{
			System.out.println("queue is full");
			return true;
		}
		if(front==-1)
			front=0;
		obj[++rear]=data;
		return true;
	}
	public Object dequeue()
	{
		if(front==rear || rear==-1)
		{
			System.out.println("there is no elements in queue");
			return false;
		}
		return obj[front++];
	}

	Object isSize()
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
	@Override
	public String toString() {
		for(int i=0;i<=rear;i++)
		{
			System.out.println(obj[i]);
		}
		return "";
	}

}
