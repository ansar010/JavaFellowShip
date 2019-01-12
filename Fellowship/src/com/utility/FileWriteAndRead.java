package com.utility;

import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
//import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import com.models.Person;

public class FileWriteAndRead 
{

	static ObjectMapper mapper=new ObjectMapper();
	static JSONParser jsonParser=new JSONParser();

	public static void fileWrite(List<Person> arrayList,String path)
	{
		String json="[";

		try {

			int temp=0;
			for (int i = 0; i < arrayList.size()-1; i++)
			{
				temp=i;
				json=json+mapper.writeValueAsString(arrayList.get(i))+",";
			}
			if(arrayList.size()>1)
				json=json+mapper.writeValueAsString(arrayList.get(temp+1))+"]";
			if(arrayList.size()==1)
				json=json+mapper.writeValueAsString(arrayList.get(arrayList.size()-1))+"]";


			FileWriter fileWrite = new FileWriter(path);
			//System.out.println("json="+json);
			fileWrite.write(json);
			fileWrite.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
}
