package Cm.com.interfaceimplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Cm.com.cliniquemodels.Appointment;
import Cm.com.cliniquemodels.Doctor;
import Cm.com.cliniquemodels.Patient;



public class DisplayImplementation implements Display
{
	List<Doctor> doctorList=new ArrayList<>();
	List<Patient> patientList=new ArrayList<>();
	List<Appointment> appointmentList=new ArrayList<>();
	ObjectMapper mapper=new ObjectMapper();
	@Override
	public void displayingDoctor() 
	{
		System.out.println("displaying doctor details");
		try {
			doctorList.addAll(mapper.readValue(new File("/home/admin1/Desktop/doctordetails.json"), new TypeReference<List<Doctor>>() {
			}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(doctorList);
	}

	@Override
	public void displayingPatient() {
		System.out.println("displaying patient details");
		try {
			patientList.addAll(mapper.readValue(new File("/home/admin1/Desktop/patientdetails.json"), new TypeReference<List<Patient>>() {
			}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(patientList);

	}

	@Override
	public void displayingAppointment() {
		System.out.println("displaying appointment details");
		/*	try {
			appointmentList.addAll(mapper.readValue(new File("/home/bridgelabz/clinique/appointment.json"), new TypeReference<List<Appointment>>() {
			}));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < appointmentList.size(); i++) 
		{
			System.out.println(appointmentList.get(i));

		}*/
		File file=new File("/home/admin1/Desktop/appointment.json");
		JSONParser parser=new JSONParser();
		try {
			Object object=parser.parse(new FileReader(file));
			JSONArray array=new JSONArray();
			array=(JSONArray) object;
			for (int i = 0; i < array.size(); i++) 
			{
				System.out.println(array.get(i));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}