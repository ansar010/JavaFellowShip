package com.fellowship.dataStructure.deque;

public class Deque
{
	private int capacity;//Size of deque
	private int front;	 //initial value of front 
	private int rear=-1; //initial value of real 
	private Object value[];//an array object to add data

	//Constructor to initialize instance variables and create deque 
	public Deque(int stringCapacity)
	{
		this.capacity=stringCapacity;
		value = new Object[stringCapacity];
		this.front=stringCapacity-1;
	}

	//=================================addFront================================

	/**
	 * purpose : To add the data in front <--this direction position
	 * @param data takes value from user
	 * @return true if added else false
	 */
	public boolean addFront(Object data)
	{
		if(front==-1)
		{
			System.out.println("Deque Overflow..");
			return false;
		}
		else
		{
			value[front--]=data;
			return true;
		}
	}
	//=================================addRear=================================
	/**
	 * purpose : To add data in rear position --> this direction
	 * @param data takes value to add 
	 * @return true if added else false
	 */
	public boolean addRear(Object data)
	{
		if(rear==capacity)
		{
			System.out.println("Deque overflow..");
			return false;
		}
		else
		{
			value[++rear]=data;
			return true;
		}
	}

	//=============================removeFront=============================
	/**
	 * purpose : To remove data from front position
	 * 
	 * @return the element removed
	 */
	public Object removeFront()
	{
		if(front>capacity)
		{
			System.out.println("Deque UnderFlow..");
			return null;
		}
		else
		{
			return value[++front];
		}

	}

	//=============================removeRear==============================
	/**
	 * purpose : To remove the element from rear position
	 * @return the removed element 
	 */
	public Object removeRear()
	{
		if(rear==-1)
		{
			System.out.println("Deque is Underflow..");
			return null;
		}
		else
		{
			return value[rear--];
		}
	}
	//=============================isEmpty=================================
	/**
	 * purpose : To check Deque is empty or not 
	 * @return true if Deque is empty or false
	 */
	public boolean isEmpty()
	{
		return rear==-1 && front>capacity;
	}
	//=============================primeCheccker===========================

	public static boolean primeChecker(String word)
	{
		int size = word.length()-1;

		// We double the size of deque arr to add front and rear 
		Deque deque = new Deque(size*2);

		//convert string as char to access each char in string
		char[] charString = word.toCharArray();

		//below two char arrays to store string 
		char firstArr[]  = new char[word.length()];
		char secondArr[] = new char[word.length()];

		boolean flag=false;

		//loop for add data in rear direction
		for(int i=0;i<charString.length;i++)
		{
			deque.addRear(charString[i]);
		}

		//loop to add data in front direction
		for(int i=charString.length-1;i>=0;i--)
		{
			deque.addFront(charString[i]);
		}

		//loop to remove in rear dir and store in firstArr
		for(int i=0;i<charString.length;i++)
		{
			firstArr[i]=(char)deque.removeRear();
		}

		//loop to remove in front dir and store in secondArr
		for(int i=0;i<charString.length;i++)
		{
			secondArr[i]=(char)deque.removeFront();
		}

		//loop to compare both first and second Array and check palindrome or not
		for(int i=0;i<firstArr.length;i++)
		{
			if(firstArr[i]!=secondArr[i])
			{
				flag=false;
			}
			else
			{
				flag=true;
			}
		}
		return flag;
	}
}

