package stockManagement;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccount 
{
	Scanner scanner=new Scanner(System.in);
	String symbol;
	static JSONParser parser=new JSONParser();
	static JSONObject name[];
	static long cId[];
	static String companySymbol[];
	String customerName;
	TransactionInJson transactionInJson=new TransactionInJson();
	ObjectMapper mapper=new ObjectMapper();
	@SuppressWarnings("unchecked")
	public StockAccount() 
	{
		//to buy 
		//sell

		Object obj,obj1,obj2;
		
		JSONArray a=new JSONArray();
		
		JSONObject object2=new JSONObject();
		
		long value=0;
		try {
			//to buy from store
			obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/stockinjson.json"));
			//get customer detail
			obj1 = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerdetail.json"));

			JSONArray array1=new JSONArray();
			JSONArray array2=new JSONArray();
			array1=(JSONArray) obj1;

			JSONArray array=new JSONArray();
			//it will take customer stock details
			obj2 = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerproductdetail.json"));				
			array2=(JSONArray) obj2;
			array=(JSONArray) obj;

			Object object[]=new Object[array.size()];


			JSONObject jsonObject[]=new JSONObject[array.size()];
			JSONObject jsonObject1=new JSONObject();

			cId=new long[array1.size()];
			name=new JSONObject[array.size()];
			int i=1;
			
			// loop to store the name of stock
			for (int j = 0; j < array.size() ; j++)
			{

				object[j]=array.get(j);

				jsonObject[j]=(JSONObject) object[j];


				String n="Stock"+i;

				name[j] = (JSONObject) jsonObject[j].get(n);
				System.out.println(name[j]);
				i++;

			}
			
			//loop to store customer id
			//System.out.println(array1.size());
			for (int j = 0; j < array1.size(); j++) 
			{
				jsonObject1=(JSONObject) array1.get(j);
				cId[j]=(long) jsonObject1.get("id");
			}
		
			System.out.println("u want to \n1.buy \n2.sell");
			int choice=scanner.nextInt();

			if(choice==1)
			{
				System.out.println("the customers are:");
				for (int j = 0; j < cId.length; j++) 
				{
					System.out.println(cId[j]);
				}
				System.out.println("the stocks are");
				for (int j = 0; j < name.length; j++) 
				{
					System.out.println(name[j].get("StockName"));
				}
				System.out.println("enter the customer id"); 
				Long customerId=scanner.nextLong();
				System.out.println("enter the stock name");
				String stockName=scanner.next();
				System.out.println("enter the number of share");
				int amount=scanner.nextInt();
				System.out.println("enter the stock symbol");
				String symbol=scanner.next();
				
				//storing customer transaction details
				transactionInJson.setId(customerId);
				transactionInJson.setStockName(stockName);
				
				int temp=0,temp1=0;
				
				//loop for get customer name to process transaction
				for (int j = 0; j < cId.length; j++) 
				{
					jsonObject1=(JSONObject) array1.get(j);
					if(customerId==(long) jsonObject1.get("id"))
					{
						temp=j;
						customerName=(String)jsonObject1.get("name");
					}
				}
				transactionInJson.setCustomerName(customerName);
				
				//to get stock name
				for (int j = 0; j < name.length; j++) 
				{

					if(name[j].get("StockName").equals(stockName))
						temp1=j;
				}
				transactionInJson.setStockName((String)name[temp1].get("StockName"));
				
				//loop for number of share
				while(amount>=(long)name[temp1].get("NumberOfShare"))
				{
					System.out.println("enter the valid amount");
					amount=scanner.nextInt();
				}
				transactionInJson.setNumberOfShare(amount);

				value=(long)buy(amount,symbol);
				transactionInJson.setMode("Buy");
				array2=(JSONArray) obj2;
				
				//
				int count=0;
				for (int j = 0; j < cId.length; j++)
				{

					object2=(JSONObject) array2.get(j);
					a=(JSONArray)object2.get("productShare");
					//System.out.println(a.size());
					//	System.out.println(temp+" "+temp1);

					for (int j2 = 0; j2 <name.length; j2++)
					{

						if(j==temp && j2==temp1)
						{
							long value1=(long)a.get(temp1)+value;
							/*	System.out.println(value1);
	    							System.out.println(a.get(j2));*/
							a.set(j2,value1);
						}
						//	object2.put(a.get(j2),a.get(j2));
					}
					//System.out.println("object2="+object2+"COUNT="+count);
					JSONArray copy=new JSONArray();
					copy.add(object2);
					fileWriteForCustomerDetail(copy,count);
					count++;

				}
				fileWriteForTransaction(transactionInJson);
			}
			else
			{
				transactionInJson.setMode("sell");
				System.out.println("the customers are:");
				for (int j = 0; j < cId.length; j++) 
				{
					System.out.println(cId[j]);
				}
				System.out.println("the stocks are");
				for (int j = 0; j < name.length; j++) 
				{
					System.out.println(name[j].get("StockName"));
				}
				System.out.println("enter the customer id"); 
				Long sellCustomerId=scanner.nextLong();
				transactionInJson.setId(sellCustomerId);
				System.out.println("enter the stock name");
				String sellStockName=scanner.next();
				transactionInJson.setStockName(sellStockName);
				System.out.println("enter the amount");
				int amount=scanner.nextInt();
				int temp=0,temp1=0,temp2=0;
				for (int j = 0; j < cId.length; j++) 
				{
					jsonObject1=(JSONObject) array1.get(j);
					if(sellCustomerId==(long) jsonObject1.get("id"))
					{
						temp=j;
						customerName=(String)jsonObject1.get("name");
					}
				}
				transactionInJson.setCustomerName(customerName);
				for (int j = 0; j < name.length; j++) 
				{

					if(name[j].get("StockName").equals(sellStockName))
					{
						symbol=(String) name[j].get("StockSymbol");
						//System.out.println(symbol);
						temp1=j;
					}
				}
				long checkValue=0;
				int count=0;
				for (int j = 0; j < cId.length; j++)
				{

					object2=(JSONObject) array2.get(j);
					a=(JSONArray)object2.get("productShare");
					//System.out.println(a.size());

					for (int j2 = 0; j2 <name.length; j2++)
					{

						if(j==temp && j2==temp1)
						{
							temp2=j2;
							//System.out.println(temp+" "+temp1);

							checkValue=(long)a.get(temp2);
							//System.out.println(checkValue+" "+amount);
							while(amount>checkValue)
							{
								if(checkValue==0)
								{
									System.out.println("u didnt buy anything in the product");
									break;
								}


								System.out.println("enter the valid amount");
								amount=scanner.nextInt();

							}
							if(checkValue!=0)
							{
								//system.out.println("ur share is "+amount);
								long nShare=checkValue-amount;
								a.set(temp2, nShare);
								//System.out.println(cId[temp]+" "+name[temp1].get("StockName")+" "+a.get(temp2));
								//System.out.println(a);
								sell(amount,symbol);
							}

						}
					}
					//	System.out.println(a);
					JSONArray copy=new JSONArray();
					copy.add(object2);
					fileWriteForCustomerDetail(copy,count);
					count++;
				}
				//	System.out.println(amount+" "+symbol);


				/*System.out.println("temp2="+temp2);
	    			System.out.println("hiHIHI"+a.get(temp2));*/

			}

		}

		catch (IOException | ParseException e) 
		{

			e.printStackTrace();
		}
	}	
	private void fileWriteForTransaction(TransactionInJson transactionInJson) 
	{
		Object object;
		String json="[";
		File file=new File("/home/admin1/Desktop/Stock/transactioninjson.json");

		try {
			if(file.length()==0)
				json=json+mapper.writeValueAsString(transactionInJson)+"]";
			else
			{
				object = parser.parse(new FileReader("/home/admin1/Desktop/Stock/transactioninjson.json"));
				JSONArray array=new JSONArray();
				array=(JSONArray) object;
				for (int i = 0; i < array.size(); i++)
				{
					//System.out.println(array.get(i));
					json=json+array.get(i)+",";
					//	System.out.println("inner Json"+json);
				}
				json=json+mapper.writeValueAsString(transactionInJson)+"]";

			}
			FileWriter fileWrite = new FileWriter("/home/admin1/Desktop/Stock/transactioninjson.json");
			//System.out.println("json="+json);
			fileWrite.write(json);
			fileWrite.flush();

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@SuppressWarnings("unchecked")
	private void sell(int amount, String symbol2) 
	{
		Object obj;

		//	JSONArray array2=new JSONArray();
		JSONArray array=new JSONArray();
		// long finalShare=0;
		transactionInJson.setNumberOfShare(amount);  
		try {
			obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/stockinjson.json"));

			array=(JSONArray) obj;

			Object object[]=new Object[array.size()];

			JSONObject jsonObject[]=new JSONObject[array.size()];

			companySymbol=new String[array.size()];
			name=new JSONObject[array.size()];
			int i=1;
			for (int j = 0; j < array.size(); j++)
			{

				object[j]=array.get(j);

				jsonObject[j]=(JSONObject) object[j];

				String n="Stock"+i;

				name[j] = (JSONObject) jsonObject[j].get(n);
				i++;
				companySymbol[j]=(String)name[j].get("StockSymbol");
			}


		} 
		catch (IOException | ParseException e) 
		{

			e.printStackTrace();
		}
		int temp=0;

		for (int j = 0; j < companySymbol.length; j++) 
		{
			if(companySymbol[j].equals(symbol2))
			{
				temp=j;
				Long share=(Long)name[j].get("NumberOfShare");
				Long price=(Long)name[j].get("SharePrice");
				share=share+amount;

				name[j].put("NumberOfShare",share);
				name[j].put("TotalAmount",(share*price));
				transactionInJson.setTime(LocalTime.now());
				Date date=new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				transactionInJson.setDate(dateFormat.format(date));
			}
		}

		JSONArray obj2=new JSONArray();
		JSONObject o=new JSONObject();
		Map<Object, Object> m=new HashMap<>();
		int  i=1;
		for (int j = 0; j < name.length; j++) {

			String n="Stock"+i;
			i++;
			m.put(n   ,name[j]);
			obj2.add(m);
			FileWriterForStock(obj2);
		}
		fileWriteForTransaction(transactionInJson);
	}
	@SuppressWarnings({ "unused", "unchecked" })
	long buy(int amount,String symbol)
	{
		Object obj;

		JSONArray array2=new JSONArray();
		JSONArray array=new JSONArray();
		long finalShare=0;

		try {
			obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/stockinjson.json"));

			array=(JSONArray) obj;

			Object object[]=new Object[array.size()];

			JSONObject jsonObject[]=new JSONObject[array.size()];

			companySymbol=new String[array.size()];
			name=new JSONObject[array.size()];
			int i=1;
			
			//loop to traverse on company symbol
			for (int j = 0; j < array.size(); j++)
			{

				object[j]=array.get(j);

				jsonObject[j]=(JSONObject) object[j];

				String n="Stock"+i;

				name[j] = (JSONObject) jsonObject[j].get(n);
				i++;
				companySymbol[j]=(String)name[j].get("StockSymbol");
			}


		} 
		catch (IOException | ParseException e) 
		{

			e.printStackTrace();
		}
		int temp=0;
		
		for (int j = 0; j < companySymbol.length; j++) 
		{	//condition to check company symbol
			if(companySymbol[j].equals(symbol))
			{
				temp=j;
				Long share=(Long)name[j].get("NumberOfShare");
				Long price=(Long)name[j].get("SharePrice");
				share=share-amount;
				finalShare=amount;
				name[j].put("NumberOfShare",share);
				name[j].put("TotalAmount",(share*price));
				transactionInJson.setTime(LocalTime.now());
				Date date=new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				transactionInJson.setDate(dateFormat.format(date));
			}
		}
		
		//to store modified share values
		JSONArray obj2=new JSONArray();
		JSONObject o=new JSONObject();
		Map<Object, Object> m=new HashMap<>();
		int  i=1;
		for (int j = 0; j < name.length; j++) {

			String n="Stock"+i;
			i++;
			m.put(n   ,name[j]);
			obj2.add(m);
			FileWriterForStock(obj2);
		}
		//	o.putAll(m);

		// System.out.println(obj2);
		return finalShare; 
	}
	@SuppressWarnings("resource")
	private void fileWriteForCustomerDetail(JSONArray object2,int count) 
	{
		if(count==0)
		{

			try {
				FileWriter file = new FileWriter("/home/admin1/Desktop/Stock/customerproductdetail.json");
				file.write(object2.toJSONString()); 
				file.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			String json1="[";
			ObjectMapper mapper=new ObjectMapper();
			Object obj1;
			try {
				FileWriter file1 = new FileWriter("/home/admin1/Desktop/Stock/customerproductdetail1.json");
				file1.write(object2.toJSONString());
				file1.flush();
				Object obj2 = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerproductdetail1.json"));
				JSONArray array3=new JSONArray();
				array3=(JSONArray) obj2;
				obj1 = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerproductdetail.json"));
				JSONArray array2=new JSONArray();
				array2=(JSONArray) obj1;
				for (int i = 0; i < array2.size(); i++)
				{

					if(i==0)
						json1=json1+array2.get(i)+",";
					else
						json1=json1+array2.get(i)+",";
				}
				//System.out.println(count+":json1="+json1);
				json1=json1+mapper.writeValueAsString(array3.get(0))+"]";
				//System.out.println("hi"+json1);
				FileWriter file = new FileWriter("/home/admin1/Desktop/Stock/customerproductdetail.json");
				file.write(json1);
				file.flush();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}


	}


	private static void FileWriterForStock(JSONArray obj2)
	{
		try (FileWriter file = new FileWriter("/home/admin1/Desktop/Stock/stockinjson.json")) 
		{

			file.write(obj2.toJSONString());  
			file.flush();

		}	 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}