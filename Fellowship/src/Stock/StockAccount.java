package Stock;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	Object object,object1[];
	JSONArray obj=new JSONArray();
	JSONObject jsonObject[];
	static long price[];
	static JSONObject name[];
	static String companySymbol[];
	static JSONParser parser =new JSONParser();
	public StockAccount()
	{	
		CustomerForStock c=new CustomerForStock();
		System.out.println("enter ur id");
		c.setId(scanner.nextInt());
		System.out.println("enter ur name");
		c.setName(scanner.next());
		System.out.println("enter ur phone number");
		c.setNum(scanner.next());
		ObjectMapper mapper=new ObjectMapper();
		String json="[";
		try {
			File file=new File("/home/admin1/Desktop/JSOn/customerdetails1.json");
			if(file.length()==0)
			{
				json=json+mapper.writeValueAsString(c)+"]";
			}
			else
			{
				Object obj = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/customerdetails1.json"));
				JSONArray array=new JSONArray();
				System.out.println(array.size());
				array=(JSONArray) obj;

				for (int i = 0; i < array.size(); i++)
				{

					if(i==0)
						json=json+array.get(i)+",";
					else
						json=json+array.get(i)+",";
				}
				json=json+mapper.writeValueAsString(c)+"]";
				/*if(count==1)
					{
						Object obj = parser.parse(new FileReader("/home/bridgelabz/customerdetails.json"));
						JSONObject jsonObject=new JSONObject();
						jsonObject=(JSONObject) obj;
						json="["+obj+",";
						json=json+mapper.writeValueAsString(c)+"]";
					}
					else
					{
						Object obj = parser.parse(new FileReader("/home/bridgelabz/customerdetails.json"));
						JSONArray array=new JSONArray();
						array=(JSONArray) obj;

						System.out.println("ARRAy"+array);
					}*/
			}}catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e) {

				e.printStackTrace();
			}
		try (FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/customerdetails1.json")) {

			file.write(json);
			System.out.println();
			System.out.println("successfully added");
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* double valueOf()
    {
    	 try {
			object = Customer.parser.parse(new FileReader("/home/bridgelabz/stocklist.json"));
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 		double totalValue=0;
    			obj=(JSONArray) object;

    			object1=new Object[obj.size()];
    			jsonObject=new JSONObject[obj.size()];
    			name=new JSONObject[obj.size()];
    			price=new long[obj.size()];
    	for (int i = 0; i < obj.size(); i++) 
    	{
    		object1[i]=obj.get(i);
    		jsonObject[i]=(JSONObject) object1[i];
    		name[i] = (JSONObject) jsonObject[i].get("Stock");
			price[i]=(long)name[i].get("TotalAmount");
			totalValue=totalValue+price[i];
		}
    	System.out.println(totalValue);

    	return totalValue*0.013771; 
    }*/
	@SuppressWarnings("unchecked")
	static void buy(int amount,String symbol)
	{
		Object obj;
		try {
			obj = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/stockmaintain.json"));
			JSONArray array=new JSONArray();

			array=(JSONArray) obj;
			//System.out.println(array);
			//System.out.println(array.size());
			Object object[]=new Object[array.size()];

			JSONObject jsonObject[]=new JSONObject[array.size()];
			companySymbol=new String[array.size()];
			name=new JSONObject[array.size()];
			int i=1;
			for (int j = 0; j < array.size(); j++)
			{
				//	System.out.println(array.get(j));
				object[j]=array.get(j);

				jsonObject[j]=(JSONObject) object[j];
				//	System.out.println(jsonObject[j]);
				String n="Stock"+i;
				//System.out.println(n);
				name[j] = (JSONObject) jsonObject[j].get(n);
				i++;
				companySymbol[j]=(String)name[j].get("StockSymbol");
			}

		} 
		catch (IOException | ParseException e) 
		{

			e.printStackTrace();
		}
		for (int j = 0; j < companySymbol.length; j++) 
		{
			if(companySymbol[j].equals(symbol))
			{
				Long share=(Long)name[j].get("NumberOfShare");
				Long price=(Long)name[j].get("SharePrice");
				share=share+amount;
				name[j].put("NumberOfShare",share);
				name[j].put("TotalAmount",(share*price));
			}
		}
		JSONArray obj2=new JSONArray();
		JSONObject o=new JSONObject();
		Map<Object, Object> m=new HashMap<>();
		int  i=1;
		for (int j = 0; j < name.length; j++) {
			//System.out.println(name[j]);
			String n="Stock"+i;
			i++;
			m.put(n,name[j]);
			obj2.add(m);
			FileWriter(obj2);
		}
		//	o.putAll(m);

		// System.out.println(obj2);

	}
	private static void FileWriter(JSONArray obj2)
	{
		try (FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/stockmaintain.json")) {


			//System.out.println(obj2.toJSONString());
			file.write(obj2.toJSONString());
			//	 System.out.println(obj2.size());
			//  System.out.println();



		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void printCustomerDetail()
	{


		ObjectMapper mapper=new ObjectMapper();
		try {

			Object obj = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/customerdetails1.json"));
			JSONArray array=new JSONArray();
			array=(JSONArray) obj;


			for (int i = 0; i < array.size(); i++)
			{
				CustomerForStock c1=mapper.readValue(array.get(i).toString(), CustomerForStock.class);
				System.out.println(c1.getId()+" "+c1.getName()+" "+c1.getNum());
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void printStockReport()
	{
		ObjectMapper mapper=new ObjectMapper();
		JSONObject name[];
		Object o[];
		try {

			Object obj = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/stockmaintain.json"));
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
				Stock1 s=new Stock1();
				s.setAmount((long)name[i].get("TotalAmount"));
				s.setNoOfShare((long)name[i].get("NumberOfShare"));
				s.setSharePrice((long)name[i].get("SharePrice"));
				s.setStockName((String)name[i].get("StockName"));
				s.setStockSymbol((String)name[i].get("StockSymbol"));
				System.out.println(s.getStockName()+" "+s.getNoOfShare()+" "+s.getSharePrice()+" "+s.getAmount()+" "+s.getStockSymbol());
			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}
	}
}