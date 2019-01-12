package Cm.com.interfaceimplementation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import Cm.com.cliniquemodels.Appointment;
import Cm.com.cliniquemodels.Doctor;
import Cm.com.cliniquemodels.Patient;

public class SearchImplementation implements Search
{
	@Override
	public Patient patientSearchByName(List<Patient> patientList,int id)
	{
		for (int i = 0; i < patientList.size(); i++)
		{
			if(id==patientList.get(i).getId())
			{

				return patientList.get(i);
			}

		}
		return null;
	}

	@Override
	public Patient patientSearchById(List<Patient> patientList,int patientId) 
	{
		for (int i = 0; i < patientList.size(); i++)
		{
			if(patientId==patientList.get(i).getId())
			{

				return patientList.get(i);
			}

		}

		return null;	
	}	



	@Override
	public Patient patientSearchByPhoneNumber(List<Patient> patientList,int id) {
		for (int i = 0; i < patientList.size(); i++)
		{
			if(id==patientList.get(i).getId())
			{

				return patientList.get(i);
			}

		}
		return null;
	}

	@Override
	public Doctor doctorSearchByName(List<Doctor> doctorList,int id) {
		for (int i = 0; i < doctorList.size(); i++)
		{
			if(id==doctorList.get(i).getId())
			{

				return doctorList.get(i);
			}

		}
		return null;

	}

	@Override
	public Doctor doctorSearchById(List<Doctor> doctorList,int id) {
		for (int i = 0; i < doctorList.size(); i++)
		{
			if(id==doctorList.get(i).getId())
			{

				return doctorList.get(i);
			}

		}
		return null;		
	}

	@Override
	public Doctor doctorSearchBySpecialist(List<Doctor> doctorList,int id) {
		for (int i = 0; i < doctorList.size(); i++)
		{
			if(id==doctorList.get(i).getId())
			{

				return doctorList.get(i);
			}

		}
		return null;

	}

	@Override
	public Doctor doctorSearchByAvailability(List<Doctor> doctorList,int id) 
	{
		Doctor doctor=new Doctor();
		int flag=0;
		for (int i = 0; i < doctorList.size(); i++)
		{
			if(id==doctorList.get(i).getId())
			{
				flag=1;
				if(doctorList.get(i).getNumberOfPatient()<5)
				{
					System.out.println("size="+doctorList.get(i).getNumberOfPatient());
					System.out.println(doctorList.get(i).getNumberOfPatient());
					doctor=doctorList.get(i);
					return doctor;
				}
				else
				{
					System.out.println("doctor is not availability ");
					return null;
				}
			}

		}
		if(flag==0)
			System.out.println("entered doctor id is invalid");
		return null;	
	}

	@Override
	public void specialist()
	{
		ObjectMapper mapper=new ObjectMapper();
		List<Doctor> listDoctor=new ArrayList<>();
		Map<Object,Object> doctorPopular=new HashMap<>(); 

		try {
			listDoctor.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
			}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listDoctor.size(); i++) 
		{
			if(doctorPopular.isEmpty())
				doctorPopular.put(listDoctor.get(i).getSpecialization(),listDoctor.get(i).getNumberOfPatient());
			else
			{
				int value=0;
				if(doctorPopular.containsKey(listDoctor.get(i).getSpecialization()))
				{
					value=value+(int)doctorPopular.get(listDoctor.get(i).getSpecialization())+(int)listDoctor.get(i).getNumberOfPatient();
					doctorPopular.put(listDoctor.get(i).getSpecialization(), value);
				}
				else
				{
					doctorPopular.put(listDoctor.get(i).getSpecialization(),listDoctor.get(i).getNumberOfPatient());

				}
			}

		}
		Map.Entry<Object,Object> firstEntry = doctorPopular.entrySet().iterator().next();
		String largestKey = (String)firstEntry.getKey();
		int largestKeyValue =(int) firstEntry.getValue();

		for (Map.Entry<Object, Object> map :doctorPopular.entrySet()) {
			int key = (int)map.getValue();
			if (key > largestKeyValue) {
				largestKeyValue = key;
				largestKey = (String)map.getKey();
			}
		}
		System.out.println("specialization: " + largestKey);
		System.out.println("Number of patients: " + largestKeyValue);


	} /*catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


	@Override
	public void popularDoctor() {
		ObjectMapper mapper=new ObjectMapper();
		List<Appointment> appointments=new ArrayList<>();
		List<Doctor> listDoctor=new ArrayList<>();
		try {
			/*appointments.addAll(mapper.readValue(new File("/home/bridgelabz/clinique/appointment.json"), new TypeReference<List<Doctor>>() {
			}));*/
			listDoctor.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
			}));
			System.out.print("the popular doctor is ");
			int big=0;
			String specialist=null,doctorName=null;;
			for (int i = 0; i < listDoctor.size(); i++) 
			{
				for (int j = i; j < listDoctor.size(); j++)
				{
					//	System.out.println(listDoctor.get(i).getNumberOfPatient()+" "+listDoctor.get(j).getNumberOfPatient());
					if(listDoctor.get(i).getNumberOfPatient()>listDoctor.get(j).getNumberOfPatient())
					{
						//	System.out.println(listDoctor.get(i).getNumberOfPatient());
						big=listDoctor.get(i).getNumberOfPatient();
						specialist=listDoctor.get(i).getSpecialization();
						doctorName=listDoctor.get(i).getName();
						//System.out.println(big);
					}
				}
			}
			System.out.println(doctorName+" more specialization in "+specialist+" and number of patient he attended is "+big);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
}
