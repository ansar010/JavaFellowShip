package Cm.com.interfaceimplementation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Cm.com.cliniquemodels.Appointment;
import Cm.com.cliniquemodels.Doctor;
import Cm.com.cliniquemodels.Patient;

public class AddImplementation  implements Entry
{
	Scanner scanner=new Scanner(System.in);
	List<Patient> patientList=new ArrayList<>();
	List<Doctor> doctorList=new ArrayList<>();
	static	 ObjectMapper mapper=new ObjectMapper();
	static Appointment appointment=new Appointment();
	@Override
	public List<Patient> addPatientDetail() 
	{
		String check;
		do
		{
			Patient patient=new Patient();
			System.out.println("enter ur name");
			String patientName=scanner.next();
			patient.setName(patientName);
			System.out.println("enter the id");
			int id=scanner.nextInt();
			boolean flag;
			flag=validatePatientID(id);
			while(flag)
			{
				System.out.println("enter the another id");
				id=scanner.nextInt();
				flag=validatePatientID(id);
			}
			patient.setId(id);
			System.out.println("enter the phone Number");
			String phoneNumber=scanner.next();
			patient.setPhoneNumber(phoneNumber);
			System.out.println("enter the age");
			int age=scanner.nextInt();

			System.out.println(age);
			patient.setAge(age);
			System.out.println(patient.getAge());
			System.out.println(patient);
			patientList.add(patient);
			System.out.println(patientList);
			System.out.println("do u want to add another person yes/no");
			check=scanner.next();

		}while(check.equals("yes"));
		System.out.println(patientList);
		return patientList;


	}
	private boolean validatePatientID(int id) 
	{
		List<Patient> patient=new ArrayList<>();

		File file=new File("/home/admin1/Desktop/patientdetails.json");
		if(file.length()==0)
		{
			if(patientList.size()==0)
			{
				System.out.println("file is empty");
				System.out.println("this is the first id");
				return false;
			}
			else
			{
				/*patient.addAll(mapper.readValue(new File("/home/bridgelabz/clinique/patientdetails.json"), new TypeReference<List<Patient>>() {
			}));*/

				for (int i = 0; i < patientList.size(); i++) 
				{
					System.out.println(patientList.get(i));
					if(id==patientList.get(i).getId())
					{
						return true;
					}
				}

			}
		}
		else
		{
			try {

				patient.addAll(mapper.readValue(new File("/home/admin1/Desktop/patientdetails.json"), new TypeReference<List<Patient>>() {
				}));
				for (int i = 0; i < patient.size(); i++) 
				{
					System.out.println(patient.get(i));
					if(id==patient.get(i).getId())
					{
						return true;
					}
				}
				if(patientList.size()!=0)
				{
					for (int i = 0; i < patientList.size(); i++) 
					{
						System.out.println(patientList.get(i));
						if(id==patientList.get(i).getId())
						{
							return true;
						}
					}
				}
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


		System.out.println("the id is new one");
		return false;
	}
	@Override
	public List<Patient> editPatientDetail(List<Patient> patientList)
	{

		if(patientList.isEmpty())
		{
			System.out.println("there is no content in the file");
		}
		else
		{
			System.out.println("which patient u want to edit");
			for (int i = 0; i < patientList.size(); i++) 
			{
				System.out.println(patientList.get(i));
			}
			System.out.println("enter the id");
			int id=scanner.nextInt();
			for (int i = 0; i < patientList.size(); i++) 
			{
				if(id==patientList.get(i).getId())
				{
					System.out.println("Enter the name again");
					String name=scanner.next();
					patientList.get(i).setName(name);
					System.out.println("enter the number");
					String number=scanner.next();
					patientList.get(i).setPhoneNumber(number);
				}
			}
		}
		System.out.println(patientList);
		return patientList;

	}
	@Override
	public List<Patient> deletePatientDetail(List<Patient> patientList) 
	{
		if(patientList.isEmpty())
		{
			System.out.println("there is no content in the file to delete");
		}
		else
		{
			System.out.println("which patient u want to delete");
			for (int i = 0; i < patientList.size(); i++) 
			{
				System.out.println(patientList.get(i));
			}
			System.out.println("enter the id");
			int id=scanner.nextInt();
			for (int i = 0; i < patientList.size(); i++) 
			{
				if(id==patientList.get(i).getId())
				{
					patientList.remove(i);
				}
			}	
		}
		return patientList;

	}
	@Override
	public List<Doctor> addDoctorDetail() {
		String check;
		do
		{
			Doctor doctor=new Doctor();
			System.out.println("enter ur name");
			String doctorName=scanner.next();
			doctor.setName(doctorName);
			System.out.println("enter the id");
			int id=scanner.nextInt();
			boolean flag;
			flag=validateDoctorId(id);
			while(flag)
			{
				System.out.println("enter the another id");
				id=scanner.nextInt();
				flag=validateDoctorId(id);
			}
			doctor.setId(id);
			System.out.println("enter the specialization");
			String specialization=scanner.next();
			doctor.setSpecialization(specialization);
			System.out.println("enter the Availability");
			String availability=scanner.next();
			doctor.setAvailability(availability);

			doctorList.add(doctor);
			System.out.println("do u want to add another person yes/no");
			check=scanner.next();

		}while(check.equals("yes"));
		System.out.println(doctorList);
		return doctorList;
	}
	private boolean validateDoctorId(int id) {

		List<Doctor> doctor=new ArrayList<>();

		File file=new File("/home/admin1/Desktop/doctordetails.json");
		if(file.length()==0)
		{
			if(doctorList.size()==0)
			{
				System.out.println("file is empty");
				System.out.println("this is the first id");
				return false;
			}
			else
			{
				/*patient.addAll(mapper.readValue(new File("/home/bridgelabz/clinique/patientdetails.json"), new TypeReference<List<Patient>>() {
			}));*/

				for (int i = 0; i < doctorList.size(); i++) 
				{
					System.out.println(doctorList.get(i));
					if(id==doctorList.get(i).getId())
					{
						return true;
					}
				}

			}
		}
		else
		{
			try {

				doctor.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
				}));
				for (int i = 0; i < doctor.size(); i++) 
				{
					System.out.println(doctor.get(i));
					if(id==doctor.get(i).getId())
					{
						return true;
					}
				}
				if(doctorList.size()!=0)
				{
					for (int i = 0; i < doctorList.size(); i++) 
					{
						System.out.println(doctorList.get(i));
						if(id==doctorList.get(i).getId())
						{
							return true;
						}
					}
				}
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


		System.out.println("the id is new one");
		return false;
	}

	@Override
	public List<Doctor> editDoctorDetail(List<Doctor> doctorList) {
		if(doctorList.isEmpty())
		{
			System.out.println("there is no content in the current doctor list");
		}
		else
		{
			System.out.println("which patient u want to edit");
			for (int i = 0; i < doctorList.size(); i++) 
			{
				System.out.println(doctorList.get(i));
			}
			System.out.println("enter the id");
			int id=scanner.nextInt();
			for (int i = 0; i < doctorList.size(); i++) 
			{
				if(id==doctorList.get(i).getId())
				{
					System.out.println("Enter the name again");
					String name=scanner.next();
					doctorList.get(i).setName(name);
					/*System.out.println("enter the number");
					String number=scanner.next();
					doctorList.get(i).setPhoneNumber(number);*/
				}
			}
		}
		System.out.println(doctorList);
		return doctorList;


	}
	@Override
	public List<Doctor> deleteDoctorDetail(List<Doctor> doctorList) {
		if(doctorList.isEmpty())
		{
			System.out.println("there is no content in the file to delete");
		}
		else
		{
			System.out.println("which patient u want to delete");
			for (int i = 0; i < doctorList.size(); i++) 
			{
				System.out.println(doctorList.get(i));
			}
			System.out.println("enter the id");
			int id=scanner.nextInt();
			for (int i = 0; i < doctorList.size(); i++) 
			{
				if(id==doctorList.get(i).getId())
				{
					doctorList.remove(i);
				}
			}	
		}
		return doctorList;
	}
	@Override
	public void fixingAppointmentForPatient(Doctor doctor,Patient patient) 
	{
		JSONParser parser=new JSONParser();
		appointment.setDoctorId(doctor.getId());
		appointment.setDoctorName(doctor.getName());
		appointment.setPatientId(patient.getId());
		appointment.setPatientName(patient.getName());
		appointment.setTime(LocalTime.now());
		Date date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		appointment.setDate(dateFormat.format(date));
		doctorCount(doctor);
		File file=new File("/home/admin1/Desktop/appointment.json");
		Object object;
		String json="[";

		try {
			if(file.length()==0)
				json=json+mapper.writeValueAsString(appointment)+"]";
			else
			{
				object = parser.parse(new FileReader("/home/admin1/Desktop/appointment.json"));
				JSONArray array=new JSONArray();
				array=(JSONArray) object;
				for (int i = 0; i < array.size(); i++)
				{
					//System.out.println(array.get(i));
					json=json+array.get(i)+",";
					//	System.out.println("inner Json"+json);
				}

				json=json+mapper.writeValueAsString(appointment)+"]";

			}
			FileWriter fileWrite = new FileWriter("/home/admin1/Desktop/appointment.json");
			//System.out.println("json="+json);
			fileWrite.write(json);
			fileWrite.flush();

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void doctorCount(Doctor doctor)
	{

		List<Doctor> listDoctor=new ArrayList<>();

		try {
			listDoctor.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
			}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listDoctor.size(); i++)
		{
			if(doctor.getId()==listDoctor.get(i).getId())
			{

				if(doctor.getNumberOfPatient()<5)
				{
					System.out.println(doctor);
					System.out.println("No of patient="+doctor.getNumberOfPatient());
					System.out.println(doctor.getNumberOfPatient());
					int count=doctor.getNumberOfPatient();
					System.out.println("HHIHI"+listDoctor);
					System.out.println("AAAAA"+listDoctor.get(i));
					listDoctor.get(i).setNumberOfPatient(++count);
					System.out.println(doctor);
					saveDoctorDetail(listDoctor);

				}
			}
		}

	}
	@Override
	public void savePatientDetail(List<Patient> patientList) {
		String json="[";
		int temp=0;
		File file=new File("/home/admin1/Desktop/patientdetails.json");
		if(file.length()==0)
		{

			try {
				for (int i = 0; i < patientList.size()-1; i++)
				{
					temp=i;
					json=json+mapper.writeValueAsString(patientList.get(i))+",";
				}
				if(patientList.size()>1)
					json=json+mapper.writeValueAsString(patientList.get(temp+1))+"]";
				if(patientList.size()==1)
					json=json+mapper.writeValueAsString(patientList.get(patientList.size()-1))+"]";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		else
		{
			try {

				List<Patient> list=new ArrayList<>();

				list.addAll(mapper.readValue(new File("/home/admin1/Desktop/patientdetails.json"), new TypeReference<List<Patient>>() {
				}));
				System.out.println("list="+list);
				int size=list.size();
				for (int i = 0; i < patientList.size(); i++) 
				{
					int temp1=0;
					for (int j = 0; j < list.size(); j++) {
						//System.out.println(i+" "+temp1);
						//System.out.println(list.get(j)+" "+patientList.get(i));
						if((list.get(j).getId()==patientList.get(i).getId()))
						{
							//System.out.println("HIHIHIH");
							temp1=1;
							list.set(j, patientList.get(i));
							break;
						}

					}
					System.out.println("temp1=="+temp1);
					if(temp1==0)
					{
						//System.out.println("list size="+size);
						list.add(size++, patientList.get(i));
						//System.out.println(list);
						//System.out.println("normal="+size);
						//System.out.println("added list  size="+list.size());
					}
				}
				System.out.println("new list"+list);
				for (int i = 0; i <list.size()-1; i++)
				{
					temp=i;
					json=json+mapper.writeValueAsString(list.get(i))+",";
				}
				if(list.size()>1)
					json=json+mapper.writeValueAsString(list.get(temp+1))+"]";
				if(list.size()==1)
					json=json+mapper.writeValueAsString(list.get(list.size()-1))+"]";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("/home/admin1/Desktop/patientdetails.json");
			fileWriter.write(json);
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@Override
	public void saveDoctorDetail(List<Doctor> doctorList) 
	{
		String json="[";
		int temp=0;
		File file=new File("/home/admin1/Desktop/doctordetails.json");
		if(file.length()==0)
		{

			try {
				for (int i = 0; i < doctorList.size()-1; i++)
				{
					temp=i;
					json=json+mapper.writeValueAsString(doctorList.get(i))+",";
				}
				if(doctorList.size()>1)
					json=json+mapper.writeValueAsString(doctorList.get(temp+1))+"]";
				if(doctorList.size()==1)
					json=json+mapper.writeValueAsString(doctorList.get(doctorList.size()-1))+"]";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		else
		{
			try {

				List<Doctor> list=new ArrayList<>();

				list.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
				}));
				System.out.println("list="+list);
				for (int i = 0; i < doctorList.size(); i++) 
				{
					int temp1=0;	
					for (int j = 0; j < list.size(); j++) {
						//System.out.println(i+" "+temp1);
						//System.out.println(list.get(j)+" "+doctorList.get(i));
						if((list.get(j).getId()==doctorList.get(i).getId()))
						{
							list.set(j, doctorList.get(i));
							temp1=1;
						}

					}
					if(temp1==0)
						list.add(doctorList.get(i));

				}
				/*System.out.println("patient list"+patientList);
				if(patientList.size()==1)
					patientList.addAll(list);*/
				System.out.println("doctorList"+list);
				for (int i = 0; i <list.size()-1; i++)
				{
					temp=i;
					json=json+mapper.writeValueAsString(list.get(i))+",";
				}
				if(list.size()>1)
					json=json+mapper.writeValueAsString(list.get(temp+1))+"]";
				if(list.size()==1)
					json=json+mapper.writeValueAsString(list.get(list.size()-1))+"]";

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter("/home/admin1/Desktop/doctordetails.json");
			fileWriter.write(json);
			fileWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	/*@Override
	public void addingPatientDetail() 
	{
		int choice;
		do
		{
			System.out.println("\n1.add \n2.edit \n3.delete \n4.exit");
			System.out.println("enter ur choice");
			choice=scanner.nextInt();
			switch (choice) {
			case 1:
					System.out.println("add the patient");
					patientList=addPatient();
					break;
			case 2:
					System.out.println("edit the patient");
					patientList=editPatient(patientList);
					break;
			case 3:
					System.out.println("delete the patient");
					patientList=deletePatient(patientList);
					break;
			case 4:
				    System.out.println("before exit u want to save the patient detail yes/no");
				    String check=scanner.next();
				    if(check.equals("yes"))
				    	savePatientDetail(patientList);
					System.exit(0);

			}
		}while(choice<5);

	}
	private List<Patient> deletePatient(List<Patient> patientList) 
	{

	}
	private List<Patient> editPatient(List<Patient> patientList)
	{

	}
	@Override
	public void addingDoctorDetail() {
		// TODO Auto-generated method stub

	}
	@Override
	public void fixingAppointmentForPatient() {
		// TODO Auto-generated method stub

	}
	List<Patient> addPatient()
	{

	@Override
	public void savePatientDetail(List<Patient> patientList) 
	{

		 String json="[";
		 ObjectMapper mapper=new ObjectMapper();
			try {

				int temp=0;
				for (int i = 0; i < patientList.size()-1; i++)
				{
					temp=i;
					json=json+mapper.writeValueAsString(patientList.get(i))+",";
				}
				if(patientList.size()>1)
					json=json+mapper.writeValueAsString(patientList.get(temp+1))+"]";
				if(patientList.size()==1)
					json=json+mapper.writeValueAsString(patientList.get(patientList.size()-1))+"]";
				FileWriter fileWriter=new FileWriter("/home/bridgelabz/clinique/patientdetails.json");
				fileWriter.write(json);
				fileWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}*/
}
