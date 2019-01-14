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
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.model.CustomerDetailsStockMan;
import com.bridgelabz.model.CustomerStockDetails;
import com.bridgelabz.model.UserDetails;


public class UtilityOops 
{

	BufferedReader bufferedReader;
	static Scanner scanner = new Scanner(System.in);

	//creating object to utilize API method's
	static ObjectMapper obMapper = new ObjectMapper();

	//creating object to parse(read json object )
	static JSONParser jsParser = new JSONParser();

	private final String REGEX_NAME = "<<name>>";
	private final String REGEX_FULLNAME = "<<full name>>";
	private final String REGEX_MOBILE_NO = "xxxxxxxxxx";
	private final String REGEX_DATE = "01/01/2016";

	public static String getWord()
	{
		return scanner.next();
	}

	public static int getInt() {
		return scanner.nextInt();
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

	/**
	 * purpose : method to write convert javaObject into jsonarry
	 * @param jObject takes java object
	 * @param jFilepath takes the file path where jsonarry write
	 */
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

	@SuppressWarnings("unchecked")
	public static String createStock()
	{
		int count=1;
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		String response = null;
		do
		{
			System.out.print("Enter the Name of stock : ");
			String stockName = UtilityOops.getWord();
			jsonObject.put("Stock name", stockName);

			System.out.print("Enter the number of share : ");
			int numOfShare = UtilityOops.getInt();
			jsonObject.put("Number of share", numOfShare);

			System.out.print("Enter the share price : ");
			int sharePrice = UtilityOops.getInt();
			jsonObject.put("Stock price", sharePrice);

			System.out.print("Enter your Stock Symbol : ");
			String stockSymbol = UtilityOops.getWord();
			jsonObject.put("Stock price", stockSymbol);

			jsonObject.put("Total amount of share",sharePrice*numOfShare);

			JSONObject element = new JSONObject();
			element.put("Stock"+count, jsonObject);

			jsonArray.add(element);

			System.out.println("\nDo you want to add more item\n Enter yes or no");
			response=UtilityOops.getWord();

			count++;
		}while(response.equals("yes"));

		return jsonArray.toJSONString();
	}

	//Method to add customer in stock account
	public static void addCustomer()
	{
		//creating customer object and initializing it's properties
		CustomerDetailsStockMan customerDetails = new CustomerDetailsStockMan();

		//creating customerDetails object and initializing it's properties
		CustomerStockDetails customerStockDetail = new CustomerStockDetails();

		System.out.println("Enter your User-id");
		int id=getInt();
		boolean b=validateCustomer(id);
		while(!b)
		{

			System.out.println("Enter the new id");
			id=getInt();
			b=validateCustomer(id);
		}
		customerDetails.setId(id);

		System.out.println("Enter ur name");
		customerDetails.setName(UtilityOops.getWord());

		System.out.println("Enter ur phone number");
		customerDetails.setMobile_num(UtilityOops.getWord());

		//code to initialize user stock values
		String sName[];
		sName=getStockName();
		customerStockDetail.setStockName(sName);
		int product[]=new int[sName.length];

		//loop to initialize customer stock details
		for (int i : product )
		{
			product[i]=0;

		}
		customerStockDetail.setStockShare(product);
		String json="[",json1="[";

		try {
			File file=new File("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json");
			if(file.length()==0)
			{
				//System.out.println(c+" "+c1);
				json=json+obMapper.writeValueAsString(customerDetails)+"]";
				json1=json1+obMapper.writeValueAsString(customerStockDetail)+"]";
			}
			else
			{
				//JSONArray a= (JSONArray) parser.parse(new FileReader("/home/bridgelabz/stock/customerdetail.json"));
				//System.out.println(a.size());
				Object obj = jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json"));
				Object obj1 = jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/CustomerStockDetails.json"));
				JSONArray array=new JSONArray();
				JSONArray array2=new JSONArray();
				array=(JSONArray) obj;
				array2=(JSONArray) obj1;
				for (int i = 0; i < array.size(); i++)
				{


					json=json+array.get(i)+",";
					json1=json1+array2.get(i)+",";

				}
				json=json+obMapper.writeValueAsString(customerDetails)+"]";
				json1=json1+obMapper.writeValueAsString(customerStockDetail)+"]";


			}}catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e) {

				e.printStackTrace();
			}
		try  {
			@SuppressWarnings("resource")
			FileWriter file = new FileWriter("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json");
			@SuppressWarnings("resource")
			FileWriter file1 = new FileWriter("/home/admin1/Desktop/OOPs/StockManagement/CustomerStockDetails.json");
			file.write(json);
			file1.write(json1);
			System.out.println();
			System.out.println("successfully added");
			file.flush();
			file1.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String[] getStockName() 
	{
		//Array to store stock name
		String sName[]=new String[3];
		JSONObject name[];//array to store json object
		Object tempObj[];//temporary object

		try {
			//it reads all object from json file
			Object obj = jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/presentStock.json"));

			JSONArray array=new JSONArray();//create json array json obj

			array=(JSONArray) obj;
			name=new JSONObject[array.size()];
			tempObj=new Object[array.size()];

			JSONObject jsonObject[]=new JSONObject[array.size()];
			int count=1;
			for (int i = 0; i < array.size(); i++)
			{

				tempObj[i]=array.get(i);

				jsonObject[i]=(JSONObject) tempObj[i];

				String concate="Stock"+count;
				name[i] = (JSONObject) jsonObject[i].get(concate);
				count++;
				sName[i]=(String) name[i].get("StockName");

			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return sName;
	}

	//method to validate customer id
	private static boolean validateCustomer(int id) 
	{
		//read file
		File file=new File("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json");

		//block if no content in file
		if(file.length()==0)
		{
			System.out.println("You are the first user..");
			return true;
		}
		else
		{

			Object obj;//json object
			int flag=1;//check condition initially true

			try {

				//read json objects
				obj = jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json"));

				//json array to store multiple json object
				JSONArray array=new JSONArray();

				JSONObject jsonObject=new JSONObject();
				array=(JSONArray) obj;

				for (int i = 0; i < array.size(); i++)
				{
					jsonObject=(JSONObject) array.get(i);

					if((long)jsonObject.get("id")==id)
					{
						System.out.println("This user-id is already exitst..!\nTry diffrent one..!");
						flag=0;
						break;
					}

				}
			} catch (IOException | ParseException e)
			{

				e.printStackTrace();
			}
			if(flag==0)
				return false;
			else
				return true;
		}
	}

	//method to get stock Details
	
	public static void getStockAccount() 
	{
		
	}
}
