package Stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Customer 
{

	static JSONParser parser=new JSONParser();
	static String productName[];
	static JSONObject name[];
	static JSONObject finalStockReport[];
	@SuppressWarnings("unchecked")
	public static void buy() throws ParseException
	{
		System.out.println("enter the number of stocks");
		Scanner scanner=new Scanner(System.in);
		int noOfStocks=scanner.nextInt();

		try {

			Object obj;
			try {
				obj = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/Stock.json"));
				JSONObject json=Inventory.convertJsonObject(obj);
				System.out.println("JSONObject="+json);



				JSONArray jsonArray=new JSONArray();
				jsonArray=(JSONArray) obj;
				Object object[]=new Object[jsonArray.size()];

				JSONObject jsonObject[]=new JSONObject[jsonArray.size()];
				productName=new String[jsonArray.size()];
				name=new JSONObject[jsonArray.size()];
				finalStockReport=new JSONObject[jsonArray.size()];

				for (int j = 0; j < object.length; j++)
				{
					object[j]=jsonArray.get(j);

					jsonObject[j]=(JSONObject) object[j];
					//System.out.println(jsonObject[j]);
					name[j] = (JSONObject) jsonObject[j].get("Stock");
					productName[j]=(String)name[j].get("StockName");

				}
			} catch (org.json.simple.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// System.out.println(obj);






			/*System.out.println(jsonObject2);
	     JSONObject name = (JSONObject) jsonObject2.get("pepsi");
	     System.out.println(name.get("NumberOfShare"));*/

		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		for(int i=0;i<noOfStocks;i++)
		{
			System.out.println("enter the stock name");

			String stockName=scanner.next();
			System.out.println("enter the number of share");
			long noOfShare=scanner.nextLong();
			for (int j = 0; j < productName.length; j++) 
			{
				if(productName[j].equals(stockName))
				{

					Long share=(Long)name[j].get("NumberOfShare");

					while(noOfShare>share)
					{
						System.out.println("we having "+share+" share of "+productName[j]);
						System.out.println("now how many share u want from this product");
						noOfShare=scanner.nextLong();
					}
					long newShare=share-noOfShare;
					Long sharePrice=(Long)name[j].get("SharePrice");
					Long amount=(Long)name[j].get("TotalAmount");
					name[j].put("NumberOfShare",newShare);

					sharePrice=noOfShare*sharePrice;
					amount=amount-sharePrice;
					name[j].put("TotalAmount",amount);
				} 

			}
		}
		JSONArray obj2=new JSONArray();
		JSONObject o=new JSONObject();
		Map<Object, Object> m=new HashMap<>();
		for (int j = 0; j < name.length; j++) {
			System.out.println(name[j]);
			m.put(productName[j],name[j]);

		}
		o.putAll(m);
		obj2.add(o);
		try (FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/Stock.json")) {

			file.write(obj2.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		scanner.close();
	}
}
