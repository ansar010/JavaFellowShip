package stockManagement;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class CustomerInJson 
{
	Scanner scanner=new Scanner(System.in);
	static JSONParser parser =new JSONParser();

	public CustomerInJson()
	{
		// TODO Auto-generated constructor stub
		CustomerDetails c=new CustomerDetails();
		CustomerProductDetail c1=new CustomerProductDetail();
		System.out.println("enter ur id");
		int id=scanner.nextInt();
		boolean b=validateCustomer(id);
		while(!b)
		{

			System.out.println("enter the new id");
			id=scanner.nextInt();
			b=validateCustomer(id);
		}
		c.setId(id);
		System.out.println("enter ur name");
		c.setName(scanner.next());
		System.out.println("enter ur phone number");
		c.setNum(scanner.next());

		String name[];
		name=getStockName();
		c1.setProductName(name);
		int product[]=new int[name.length];
		for (int i = 0; i < product.length; i++)
		{
			product[i]=0;

		}
		c1.setProductShare(product);
		ObjectMapper mapper=new ObjectMapper();
		String json="[",json1="[";

		try {
			File file=new File("/home/admin1/Desktop/Stock/customerdetail.json");
			if(file.length()==0)
			{
				//System.out.println(c+" "+c1);
				json=json+mapper.writeValueAsString(c)+"]";
				json1=json1+mapper.writeValueAsString(c1)+"]";
			}
			else
			{
				//JSONArray a= (JSONArray) parser.parse(new FileReader("/home/bridgelabz/stock/customerdetail.json"));
				//System.out.println(a.size());
				Object obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerdetail.json"));
				Object obj1 = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerproductdetail.json"));
				JSONArray array=new JSONArray();
				JSONArray array2=new JSONArray();
				array=(JSONArray) obj;
				array2=(JSONArray) obj1;
				for (int i = 0; i < array.size(); i++)
				{

					
						json=json+array.get(i)+",";
						json1=json1+array2.get(i)+",";
					
				}
				json=json+mapper.writeValueAsString(c)+"]";
				json1=json1+mapper.writeValueAsString(c1)+"]";
				//System.out.println("hi");


			}}catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e) {

				e.printStackTrace();
			}
		try  {
			FileWriter file = new FileWriter("/home/admin1/Desktop/Stock/customerdetail.json");
			FileWriter file1 = new FileWriter("/home/admin1/Desktop/Stock/customerproductdetail.json");
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

	private boolean validateCustomer(int id)
	{
		File file=new File("/home/admin1/Desktop/Stock/customerdetail.json");
		if(file.length()==0)
		{
			System.out.println("this is the first id");
			return true;
		}
		else
		{
			Object ob;
			int flag=0;
			try {
				ob = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerdetail.json"));
				JSONArray arra=new JSONArray();
				JSONObject jsonObject=new JSONObject();
				arra=(JSONArray) ob;

				for (int i = 0; i < arra.size(); i++)
				{
					jsonObject=(JSONObject) arra.get(i);
					//	System.out.println(jsonObject.get("id"));
					if((long)jsonObject.get("id")==id)
					{
						System.out.println("the Id is already there try again another number");
						flag=1;
						break;
					}

				}
			} catch (IOException | ParseException e)
			{

				e.printStackTrace();
			}
			if(flag==1)
				return false;
			else
				return true;
		}
	}
	private String[] getStockName() 
	{
		String pName[]=new String[3];
		JSONParser parser =new JSONParser();
		//ObjectMapper mapper=new ObjectMapper();
		JSONObject name[];
		Object o[];
		try {

			Object obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/stockinjson.json"));
			//System.out.println(obj);
			JSONArray array=new JSONArray();
			array=(JSONArray) obj;
			//System.out.println(array.size());
			name=new JSONObject[array.size()];
			o=new Object[array.size()];

			JSONObject jsonObject[]=new JSONObject[array.size()];
			int j=1;
			for (int i = 0; i < array.size(); i++)
			{

				o[i]=array.get(i);

				jsonObject[i]=(JSONObject) o[i];

				//System.out.println(jsonObject[i]);
				String cat="Stock"+j;
				name[i] = (JSONObject) jsonObject[i].get(cat);
				j++;
				pName[i]=(String) name[i].get("StockName");

			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
		return pName;
	}
	static void printCustomerDetail()
	{
		File file=new File("/home/admin1/Desktop/Stock/customerdetail.json");
		if(file.length()==0)
		{
			System.out.println("there is no content in file");

		}
		else
		{
			ObjectMapper mapper=new ObjectMapper();
			try {

				Object obj = parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerdetail.json"));
				Object obj1=parser.parse(new FileReader("/home/admin1/Desktop/Stock/customerproductdetail.json"));

				JSONArray array=new JSONArray();
				array=(JSONArray) obj;
				JSONArray array1=new JSONArray();
				array1=(JSONArray) obj1;


				for (int i = 0; i < array.size(); i++)
				{
					System.out.println();
					CustomerDetails c1=mapper.readValue(array.get(i).toString(), CustomerDetails.class);
					System.out.print("Id="+c1.getId()+" Name="+c1.getName()+" Phone Number="+c1.getNum());
					CustomerProductDetail c2=mapper.readValue(array1.get(i).toString(), CustomerProductDetail.class);

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

