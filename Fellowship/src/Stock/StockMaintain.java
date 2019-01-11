package Stock;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockMaintain {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {


		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("StockName", "pepsi");
		jsonObject.put("NumberOfShare", new Integer(500));
		jsonObject.put("SharePrice", new Integer(200));
		jsonObject.put("StockSymbol","pep");

		int share=(int)jsonObject.get("NumberOfShare");
		int price=(int)jsonObject.get("SharePrice");
		jsonObject.put("TotalAmount",(share*price) );
		
		JSONObject jsonObject3=new JSONObject();
		jsonObject3.put("Stock1", jsonObject);


		JSONObject jsonObject1=new JSONObject();
		jsonObject1.put("StockName", "maa");
		jsonObject1.put("NumberOfShare", new Integer(400));
		jsonObject1.put("SharePrice", new Integer(100));

		jsonObject1.put("StockSymbol","mango");
		share=(int)jsonObject1.get("NumberOfShare");
		price=(int)jsonObject1.get("SharePrice");
		jsonObject1.put("TotalAmount",(share*price) );

		JSONObject jsonObject4=new JSONObject();
		jsonObject4.put("Stock2", jsonObject1);



		JSONObject jsonObject2=new JSONObject();
		jsonObject2.put("StockName", "coke");
		jsonObject2.put("NumberOfShare", new Integer(600));
		jsonObject2.put("SharePrice", new Integer(50));
		jsonObject2.put("StockSymbol","co");
		share=(int)jsonObject2.get("NumberOfShare");
		price=(int)jsonObject2.get("SharePrice");
		jsonObject2.put("TotalAmount",(share*price) );
		
		JSONObject jsonObject5=new JSONObject();
		jsonObject5.put("Stock3", jsonObject2);



		JSONArray obj=new JSONArray();

		obj.add(jsonObject3);
		obj.add(jsonObject4);
		obj.add(jsonObject5);

		try (FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/stockmaintain.json")) {

			file.write(obj.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);
	}
}