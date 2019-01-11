package Stock;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




public class Inventory {
	static String productName[];
	static JSONObject name[];

	@SuppressWarnings({ "unchecked" })
	public static JSONObject convertJsonObject(Object obj)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=(JSONArray) obj;

		Object object[]=new Object[jsonArray.size()];

		JSONObject jsonObject[]=new JSONObject[jsonArray.size()];
		productName=new String[jsonArray.size()];
		name=new JSONObject[jsonArray.size()];
		// finalStockReport=new JSONObject[jsonArray.size()];

		for (int j = 0; j < object.length; j++)
		{
			object[j]=jsonArray.get(j);

			jsonObject[j]=(JSONObject) object[j];
			//	System.out.println(jsonObject[j]);
			name[j] = (JSONObject) jsonObject[j].get("Stock");
			productName[j]=(String)name[j].get("StockName");

		}
		JSONObject o=new JSONObject();
		Map<Object, Object> m=new HashMap<>();
		for (int j = 0; j < name.length; j++) {
			//System.out.println(name[j]);
			m.put(productName[j],name[j]);

		}
		o.putAll(m);
		return o;

	}
}
