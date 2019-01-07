package com.fellowship.dataStructure.orderedLinkedList;

public class OrderedLinkedList 
{
	class Node
	{
		Object data;
		Node next;

		public Node(Object data) {
			this.data=data;
		}
	}
	private Node head;

	public boolean add(Object data)
	{
		System.out.println("data1="+data);
		Node n=new Node(data);
		if(head==null)
		{
			head=n;
			return true;
		}

		Node t=head,temp=head;
		Node prev=head;
		while(t!=null)
		{
			prev=t;
			if((int)t.data >(int) data)
			{

				n.next=prev;

				if(prev==head)
					head=n;
				else
					temp.next=n;
				return true;
			}
			temp=t;
			t=t.next;
		}
		prev.next=n;
		return true;
	}

	public boolean search(Object data)
	{
		if(head==null)
		{
			System.out.println("no elements to search");
			return false;
		}
		Node t=head;
		while(t!=null)
		{
			if(t.data.equals(data))
			{
				pop(data);
				return true;
			}

			t=t.next;

		}
		add(data);
		return true;
	}

	public boolean pop(Object data) {

		Node t=head;
		if(head==null)
		{
			System.out.println("no elements to delete");
			return false;
		}
		Node prev=t;
		Node temp=prev;
		while(t.next!=null)
		{
			if(head.data.equals(data))
			{
				head=t.next;
				t.next=null;
				return true;
			}
			if(temp.data.equals(data) && prev!=head)
			{
				remove(data,t,prev);
				return true;
			}
			prev=t.next;
			if(prev.data.equals(data))
			{
				remove(data,t,prev);
				return true;
			}
			t=t.next;
		}

		return true;

	}
	
	public void remove(Object data, Node prev,Node t) {
		if(head==null)
		{
			System.out.println("no element in the list");
		}
		else
		{
			prev.next=t.next;
			t.next=null;
		}
	}
	
	@Override
	public String toString() {
		Node t=head;

		while(t!=null)
		{
			System.out.println(t.data+" ");
			t=t.next;
		}
		return " ";
	}
}
