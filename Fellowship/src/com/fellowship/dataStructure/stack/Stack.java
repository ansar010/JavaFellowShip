/*************************************************************************
 * purpose : program to create stack and it's functionalities
 * 
 * @author Ansar
 * @version 1.2
 * @since 7/01/2019
 * 
 *************************************************************************/
package com.fellowship.dataStructure.stack;


public class Stack
{
	int length;
	//Nested class for node
	private class Node
	{
		Object data;//stack's data
		Node next;//address of next node

		//Constructor to initialize data
		public Node(Object data)
		{
			this.data=data;
		}
	}
	private Node top;//place of recently inserted data

	//=====================================isEmpty========================================
	/**
	 * purpose : To check stack is empty or not
	 *
	 * @return true if the stack is empty else faslse
	 */
	public boolean isEmpty()
	{
		return top==null;//if no value in top then it is empty
	}

	//=====================================peek============================================
	/**
	 * purpose : To display the data present in top 
	 * 
	 * @return the data present in top
	 */
	public Object peek()
	{
		return  top.data;
	}

	//=====================================push=============================================
	/**
	 * purpose : To push(insert/add) element in stack
	 * 
	 * @param data it takes data from user
	 * @return return true if data added
	 */
	public boolean push(Object data)
	{
		Node node = new Node(data);//create new node 

		node.next=top;//store address on next node
		top=node;//store data on top
		length++;//incrementing to find size of stack
		return true;
	}

	//=====================================pop==============================================
	/**
	 * purpose : To pop(remove/delete) element from stack
	 * 
	 * @return true if data popped else false
	 */
	public Object pop()
	{
		//condition to check data is there in stack
		if(top==null)
		{
			System.out.println("No data in stack to pop..!");
			return null;
		}
		else
		{	//data variable to store top value
			Object data=top.data;
			top=top.next;//reassign to remove current top point 
			length--;
			return  data;
		}
	}

	//=================================isParenthesisBalance=================================
	/**
	 * purpose : to check given parenthesis balanced or not
	 * 
	 * @param expression it takes the expression from the user
	 * @return true if given expression is balance or false
	 */
	public  boolean isParenthesisBalance(String expression)
	{
		//Creating stack object
		Stack stack = new Stack();
		//Converting string into char array
		char exprsnChar[]=expression.toCharArray();
		//index variable to traverse over stack 
		int index=0;
		while(index<exprsnChar.length)
		{
			if(exprsnChar[index]=='{'||exprsnChar[index]=='('||exprsnChar[index]=='[')
			{
				stack.push(exprsnChar[index]);
			}
			else if(  exprsnChar[index]=='}' && stack.peek()==(Character)'{'
					||exprsnChar[index]==')' && stack.peek()==(Character)'('
					||exprsnChar[index]==']' && stack.peek()==(Character)'[')
			{
				stack.pop();
			}
			index++;
		}

		return stack.isEmpty();

	}
	//=================================size=================================================

	/**
	 * purpose : to find the size of created stack
	 * @return the size of stack
	 */
	public int size()
	{
		return length;
	}
}
