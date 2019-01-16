package com.bridgelabz.stockReport;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.objectOriented.UtilityOops;
import com.bridgelabz.stock.model.CustomerDetailsStockMan;
import com.bridgelabz.stock.model.CustomerStockDetails;

import stockManagement.CustomerDetails;
import stockManagement.CustomerStockDetail;

public class Customer
{
	//creating object to utilize API method's
	static ObjectMapper obMapper = new ObjectMapper();

	//creating object to parse(read json object )
	static JSONParser jsParser = new JSONParser();

	//Method to add customer in stock account
	public Customer()
	{
		//creating customer object and initializing it's properties
		CustomerDetailsStockMan customerDetails = new CustomerDetailsStockMan();

		//creating customerDetails object and initializing it's properties
		CustomerStockDetails customerStockDetail = new CustomerStockDetails();

		System.out.println("Enter your User-id");
		int id=UtilityOops.getInt();
		boolean b=validateCustomer(id);
		while(!b)
		{

			System.out.println("Enter the new id");
			id=UtilityOops.getInt();
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

	public static void printCustomerDetail()
	{
		File file=new File("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json");
		if(file.length()==0)
		{
			System.out.println("there is no content in file");

		}
		else
		{
			ObjectMapper mapper=new ObjectMapper();
			try {

				Object obj =jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/CustomerDetails.json"));
				Object obj1=jsParser.parse(new FileReader("/home/admin1/Desktop/OOPs/StockManagement/CustomerStockDetails.json"));

				JSONArray array=new JSONArray();
				array=(JSONArray) obj;
				JSONArray array1=new JSONArray();
				array1=(JSONArray) obj1;


				for (int i = 0; i < array.size(); i++)
				{
					System.out.println();
					CustomerDetails c1=mapper.readValue(array.get(i).toString(), CustomerDetails.class);
					System.out.print("Id="+c1.getId()+" Name="+c1.getName()+" Phone Number="+c1.getNum());
					CustomerStockDetail c2=mapper.readValue(array1.get(i).toString(), CustomerStockDetail.class);

					String name[]=c2.getProductName();
					int share[]=c2.getProductShare();

					System.out.print(" Product Share=[");
					for (int j = 0; j < share.length; j++) 
					{
						System.out.print(share[j]+" ");
					}
					System.out.print("]");
					System.out.print(" Product Name=[");
					for (int j = 0; j < name.length; j++) 
					{

						System.out.print(name[j]+" ");
					}
					System.out.print("]");
				}

				System.out.println();
				//	CustomerDetail c2=mapper.readValue(src, valueType)


			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
