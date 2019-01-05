/********************************************************************
 * 
 * purpose : Program to check the given String is palindrome or not by using Deque
 * @author Ansar
 * @version 1.2
 * @since 5/01/2019
 */
package com.fellowship.dataStructure.deque;
import com.fellowship.utility.Utility;

public class PalindromeChecker
{
	public static void main(String[] args)
	{
		System.out.println("Enter the word to check palindrome");
		String word = Utility.getLine();

		boolean result=Deque.primeChecker(word);

		if(result==true)
		{
			System.out.println("The given String : "+word+" is Palindrome");
		}
		else
		{
			System.out.println("The given String : "+word+" is Not Palindrome");
		}
	}

}
