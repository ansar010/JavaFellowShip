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

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.model.GroceryBean;
import com.bridgelabz.model.UserDetails;


public class UtilityOops 
{

	BufferedReader bufferedReader;
	static Scanner scanner = new Scanner(System.in);

	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>>";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "01/01/2016";

	public static String getWord()
	{
		return scanner.next();
	}

	public static Long getLong()
	{
		return scanner.nextLong();
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

	public void jObjToJsonArr(Object jObject,String jFilepath)
	{
		//creating object to utilize API method's
		ObjectMapper obMapper = new ObjectMapper();

		//creating object to parse(read json object )
		JSONParser jsParser = new JSONParser();

		//To represent json object as array
		String jsonArr = "[";

		File file = new File(jFilepath);

		try {
			if(file.length()==0)
			{

				jsonArr=jsonArr+obMapper.writeValueAsString(jObject)+"]";
			}
			else
			{
				Object jObject2;
				jObject2=jsParser.parse(new FileReader(file));

				JSONArray jarray = new JSONArray();
				jarray=(JSONArray) jObject2;

				for(int i=0;i<jarray.size();i++)
				{
					jsonArr=jsonArr+jarray.get(i)+",";
				}
				jsonArr=jsonArr+obMapper.writeValueAsString(jObject)+"]";
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		FileWriter f;
		try {
			f = new FileWriter(file);
			f.write(jsonArr);
			f.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//	public static void filewrite(GroceryBean groceryBean) 
	//	{
	//		ObjectMapper mapper=new ObjectMapper();	
	//		String json="[";
	//		JSONParser parser=new JSONParser();		
	//		try {
	//			File file=new File("/home/admin1/Desktop/JSOn/data.json");
	//
	//			if(file.length()==0)
	//			{
	//
	//				json=json+mapper.writeValueAsString(groceryBean)+"]";
	//			}
	//			else
	//			{
	//				Object object;
	//				try {
	//					object = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/data.json"));
	//					JSONArray array=new JSONArray();
	//					array=(JSONArray) object;
	//					for (int j = 0; j < array.size(); j++) {
	//						json=json+array.get(j)+",";
	//					}
	//					json=json+mapper.writeValueAsString(groceryBean)+"]";
	//				} catch (org.json.simple.parser.ParseException e) {
	//					e.printStackTrace();
	//				}
	//				
	//			}
	//
	//		}
	//		catch (IOException e1) {
	//			e1.printStackTrace();
	//		}
	//		try  {
	//
	//			FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/data.json");
	//			file.write(json);
	//			file.flush();
	//		}
	//		catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//
	//	}
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
