/**
 * purpose : write frequently called methods to create unordered linked list
 */
package com.fellowship.DataStructure.UnorderedList;

public class UnOrderedListUtility
{
	//Nested class for node 
	class Node
	{
		Object data;//the node's data
		Node next;

		public Node(Object data)
		{
			this.data = data;
		}
	}

	private Node head;//Initial node head(null)

	public boolean add(Object data) 
	{
		Node n = new Node(data); // new node object and data
		Node tempHead = head;//Assigning head to temporary 

		//check first node 
		if(head == null)
		{
			//assign data to first node
			head = n;
			return true;
		}
		
		//To iterate over the node to find last node 
		while(tempHead.next!=null)
		{
			tempHead=tempHead.next;
		}
		tempHead.next=n;
		return true;
	}
	
	

	public boolean search(String ele)
	{
		if(head==null)
		{
			System.out.println("There is no element to search.. ");
		}
		Node t = head;
		while(t.next!=null)
		{
			if(t.data.equals(ele))
			{
				remove(ele);
				return true;
			}
			t=t.next;
		}
		return true;
	}



	private boolean remove(String ele) 
	{	
		Node t = head;
		if(head==null)
		{
			System.out.println("No Element to delete..!");
		}
		
		Node prev=t;
		Node temp=prev;
		while(t.next!=null)
		{
			//if the searched data is in first node
			if(head.data.equals(ele))
			{
				head=t.next;
				t.next=null;
				return true;
			}
			
			//if the searched element next to head
			if(prev)
		}
	}
}