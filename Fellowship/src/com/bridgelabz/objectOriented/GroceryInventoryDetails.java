package com.bridgelabz.objectOriented;

import com.bridgelabz.model.GroceryBean;

public class GroceryInventoryDetails
{			
	public static void main(String[] args) 
	{	
		GroceryBean grBean = new GroceryBean();
		UtilityOops utilityOops = new UtilityOops();

		String response;
		do
		{
			System.out.println("Enter the name of grocery : ");
			String name = UtilityOops.getWord();
			grBean.setName(name);

			System.out.println("Enter the weight : ");
			long weight = UtilityOops.getLong();
			grBean.setWeight(weight);

			System.out.println("Enter the price : ");
			Long price = UtilityOops.getLong();
			grBean.setPricePerKg(price);

			utilityOops.jObjToJsonArr(grBean,"/home/admin1/Desktop/OOPs/GroceryInventory.json");

			System.out.println("Do you want to add more item\n Enter yes or no");
			response=UtilityOops.getWord();
		}while(response.equals("yes"));
	}
}
