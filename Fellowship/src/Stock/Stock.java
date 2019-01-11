package Stock;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Stock {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{


		JSONObject jsonObject=new JSONObject();
		jsonObject.put("StockName", "pepsi");
		jsonObject.put("NumberOfShare", new Integer(50));
		jsonObject.put("SharePrice", new Integer(200));
		jsonObject.put("TotalAmount", new Integer(200*50));
		JSONObject jsonObject3=new JSONObject();
		jsonObject3.put("Stock", jsonObject);



		JSONObject jsonObject1=new JSONObject();
		jsonObject1.put("StockName", "maa");
		jsonObject1.put("NumberOfShare", new Integer(40));
		jsonObject1.put("SharePrice", new Integer(100));
		jsonObject1.put("TotalAmount", new Integer(40*100));
		JSONObject jsonObject4=new JSONObject();
		jsonObject4.put("Stock", jsonObject1);



		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("StockName", "coke");
		jsonObject2.put("NumberOfShare", new Integer(60));
		jsonObject2.put("SharePrice", new Integer(50));
		jsonObject2.put("TotalAmount", new Integer(60*50));
		JSONObject jsonObject5=new JSONObject();
		jsonObject5.put("Stock", jsonObject2);



		JSONArray obj=new JSONArray();

		obj.add(jsonObject3);
		obj.add(jsonObject4);
		obj.add(jsonObject5);

		try (FileWriter file = new FileWriter("/home/bridgelabz/stock.json")) {

			file.write(obj.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}
}