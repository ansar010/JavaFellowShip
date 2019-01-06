package com.fellowship.dataStructure.queue;

import com.fellowship.utility.Utility;

public class SimulateBanking
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the number person to add in queue : ");
		int sizeOfQueue = Utility.getInt();
		
		Queue queue = new Queue(sizeOfQueue);
		
		int numOfPerson =sizeOfQueue;
		System.out.println("Enter "+sizeOfQueue+" person's name to enqueue");
		queue.cashCounter(numOfPerson);
	}
}
