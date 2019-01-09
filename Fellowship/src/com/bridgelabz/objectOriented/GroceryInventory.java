package com.bridgelabz.objectOriented;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.model.GroceryBean;
import com.fellowship.utility.Utility;

public class GroceryInventory 
{
	public static void main(String[] args) 
	{
		String responce =null;
		do 
		{
			GroceryBean groceryBean = new GroceryBean();
			System.out.println("Enter the name of grocery : ");
			String name = Utility.getWord();
			groceryBean.setName(name);

			System.out.println("Enter the weight : ");
			long weight = Utility.getLong();
			groceryBean.setWeight(weight);

			System.out.println("Enter the price : ");
			Long price = Utility.getLong();
			groceryBean.setPricePerKg(price);
			filewrite(groceryBean);
			System.out.println("Do you want to add more item\n Enter yes or no");
			responce = Utility.getWord();
			
		}while(responce.equals("yes"));
		Utility.close();
	}
	private static void filewrite(GroceryBean groceryBean) 
	{
		ObjectMapper mapper=new ObjectMapper();	
		String json="[";
		JSONParser parser=new JSONParser();		
		try {
			File file=new File("/home/admin1/Desktop/JSOn/data.json");

			if(file.length()==0)
			{

				json=json+mapper.writeValueAsString(groceryBean)+"]";
			}
			else
			{
				Object object;
				try {
					object = parser.parse(new FileReader("/home/admin1/Desktop/JSOn/data.json"));
					JSONArray array=new JSONArray();
					array=(JSONArray) object;
					for (int j = 0; j < array.size(); j++) {
						json=json+array.get(j)+",";
					}
					json=json+mapper.writeValueAsString(groceryBean)+"]";
				} catch (org.json.simple.parser.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		try  {
			System.out.println("hyhihih");

			FileWriter file = new FileWriter("/home/admin1/Desktop/JSOn/data.json");
			file.write(json);
			file.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}

