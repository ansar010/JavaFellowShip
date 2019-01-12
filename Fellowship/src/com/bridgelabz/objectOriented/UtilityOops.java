package com.bridgelabz.objectOriented;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgelabz.model.UserDetails;

public class UtilityOops 
{

	BufferedReader bufferedReader;
	Scanner scanner = new Scanner(System.in);

	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>>";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "01/01/2016";

	public String getWord()
	{
		return scanner.next();
	}

	public String formatDate(TemporalAccessor date) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		return formatter.format(date); 

	}

	//Pattern pattern=null ;
	public String replaceUserdata(UserDetails userDetails,String message)
	{
		Pattern pattern = Pattern.compile(REGEX_NAME);
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll(userDetails.getFirstName());

		pattern = Pattern.compile(REGEX_FULLNAME);
		matcher = pattern.matcher(message);
		message = matcher.replaceAll(userDetails.getLastName());

		pattern = Pattern.compile(REGEX_MOBILE_NO);
		matcher = pattern.matcher(message);
		message = matcher.replaceAll(userDetails.getMobileNo());

		pattern = Pattern.compile(REGEX_DATE);
		matcher = pattern.matcher(message);
		message = matcher.replaceAll(String.valueOf(formatDate(userDetails.getDate())));


		return message;
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
