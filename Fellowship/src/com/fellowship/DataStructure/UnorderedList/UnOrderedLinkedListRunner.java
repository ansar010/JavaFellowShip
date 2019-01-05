package com.fellowship.DataStructure.UnorderedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fellowship.utility.Utility;

public class UnOrderedLinkedListRunner 
{

	public static void main(String[] args) throws FileNotFoundException 
	{	//It gets the file and open it in read mode
		FileReader filereader = new FileReader(new File("/home/admin1/Desktop/ProgFiles/UnOrdLinkedListData.txt"));
		
		//creating buffer reader to read the given file 
		BufferedReader bufReader = new BufferedReader(filereader);
		
		//Creating linkedLis Object to utilize its methods
		UnOrderedListUtility unOrdList = new UnOrderedListUtility();

		String line; //total number of line/content present in file

		try {
			while((line=bufReader.readLine())!=null)
			{									//calling function to split string 
				String[] words = line.split(" ");//based on regex " " n store in str[]

				for(int i=0;i<words.length;i++)
				{
					unOrdList.add(words[i]);
				}
				System.out.println(unOrdList);

				String check=null;

				do
				{
					System.out.print("Enter the element to be searched : ");
					String ele = Utility.getLine();
					unOrdList.search(ele);
					System.out.println("Result After search : ");
					System.out.println(unOrdList);
					System.out.println("Do you want to continue the search y->Yes n->No ");
					check = Utility.getLine();
				}while(check.equalsIgnoreCase("y"));
			}									
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
