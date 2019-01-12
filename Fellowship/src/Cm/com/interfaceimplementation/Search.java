package Cm.com.interfaceimplementation;

import java.util.List;

import Cm.com.cliniquemodels.Doctor;
import Cm.com.cliniquemodels.Patient;

public interface Search 
{
	Patient patientSearchByName(List<Patient> list,int id);
	Patient patientSearchById(List<Patient> list,int id);
	Patient patientSearchByPhoneNumber(List<Patient> list,int id);
	Doctor doctorSearchByName(List<Doctor> list,int id);
	Doctor doctorSearchById(List<Doctor> list,int id);
	Doctor doctorSearchBySpecialist(List<Doctor> list,int id);
	Doctor doctorSearchByAvailability(List<Doctor> list,int id);
	void specialist();
	void popularDoctor();
}
