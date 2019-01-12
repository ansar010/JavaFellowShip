package Cm.com.interfaceimplementation;

import java.util.List;

import Cm.com.cliniquemodels.Doctor;
import Cm.com.cliniquemodels.Patient;

public interface Entry
{
	List<Patient> addPatientDetail();
	List<Patient> editPatientDetail(List<Patient> patientList);
	List<Patient> deletePatientDetail(List<Patient> patientList);
	List<Doctor> addDoctorDetail();
	List<Doctor> editDoctorDetail(List<Doctor> doctorList);
	List<Doctor> deleteDoctorDetail(List<Doctor> doctorList);
	void fixingAppointmentForPatient(Doctor doctor,Patient patient);
	void savePatientDetail(List<Patient> patientList);
	void saveDoctorDetail(List<Doctor> doctorList);
}
