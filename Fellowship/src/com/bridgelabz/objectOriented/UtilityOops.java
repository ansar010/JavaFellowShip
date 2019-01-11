package com.bridgelabz.objectOriented;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

public class UtilityOops 
{
	BufferedReader bufferedReader;

	public String inputString()
	{
		try {
			return bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String formatDate(String date) 
	{
		DateTimeFormatter formatter = new DateTimeFormatter.ofPattern("dd/mm/yyyy");

		return s.format(printDate(date));
	}
	/**
	 * purpose : method to read file 
	 * @param filePath takes file path
	 * @return
	 */
	public  String readFile(String filePath)
	{
		File file = new File(filePath);
		FileReader fileReader;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			StringBuilder stringBuilder = new StringBuilder();
			String line = bufferedReader.readLine();
			while(line != null)
			{
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
				line=bufferedReader.readLine();
			}
			return stringBuilder.toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		finally
		{
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * purpose : method to write the data in file 
	 * @param data takes from user
	 * @param fileName takes file path
	 */
	public static void writeFile(String data,String fileName)
	{
		FileWriter fileWriter;
		PrintWriter out = null;
		try {
			fileWriter = new FileWriter(fileName,true);
			//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			out = new PrintWriter(fileWriter);
			out.print(data);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}
}
