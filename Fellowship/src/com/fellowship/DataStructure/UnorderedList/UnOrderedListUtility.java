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

	public boolean search(Object data)
	{	
		Node temp = head;
		if(head==null)
		{
			System.out.println("No data to be search..");
			return false;
		}
		while(temp!=null)
		{
			if(temp.data.equals(data))
			{
				remove(data);
				return true;
			}
			temp=temp.next;
		}
		add(data);
		return true;
	}



	public boolean remove(Object data) 
	{
		Node temp = head;
		if(head==null)
		{
			System.out.println("No data to delete..");
			return false;
		}
		Node prev=temp;
		Node q=prev;
		while(temp.next!=null)
		{
			if(head.data.equals(data))
			{
				head=temp.next;
				temp.next=null;
				return true;
			}
			prev=temp.next;
			if(prev.data.equals(data))
			{
				prev.next=temp.next;
				temp.next=null;
				return true;
			}
			temp=temp.next;
		}
		
		return true;
}
}
