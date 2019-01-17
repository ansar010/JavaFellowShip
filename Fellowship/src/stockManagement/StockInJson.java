package stockManagement;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockInJson 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {


		JSONObject jObj1=new JSONObject();
		jObj1.put("StockName", "Birla");
		jObj1.put("NumberOfShare", new Integer(500));
		jObj1.put("SharePrice", new Integer(200));
		jObj1.put("StockSymbol","B");
		int share=(int)jObj1.get("NumberOfShare");
		int price=(int)jObj1.get("SharePrice");
		jObj1.put("TotalAmount",(share*price) );

		JSONObject element1=new JSONObject();
		element1.put("Stock1", jObj1);


		JSONObject jObj2=new JSONObject();
		jObj2.put("StockName", "ShareKhan");
		jObj2.put("NumberOfShare", new Integer(400));
		jObj2.put("SharePrice", new Integer(100));
		jObj2.put("StockSymbol","S");
		share=(int)jObj2.get("NumberOfShare");
		price=(int)jObj2.get("SharePrice");
		jObj2.put("TotalAmount",(share*price) );

		JSONObject element2=new JSONObject();
		element2.put("Stock2", jObj2);



		JSONObject jObj3=new JSONObject();
		jObj3.put("StockName", "Adams");
		jObj3.put("NumberOfShare", new Integer(600));
		jObj3.put("SharePrice", new Integer(50));
		jObj3.put("StockSymbol","ADA");
		share=(int)jObj3.get("NumberOfShare");
		price=(int)jObj3.get("SharePrice");
		jObj3.put("TotalAmount",(share*price) );

		JSONObject element3=new JSONObject();
		element3.put("Stock3", jObj3);



		JSONArray obj=new JSONArray();

		obj.add(element1);
		obj.add(element2);
		obj.add(element3);

		try (FileWriter file = new FileWriter("/home/admin1/Desktop/Stock/stockinjson.json")) {

			file.write(obj.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}
}
