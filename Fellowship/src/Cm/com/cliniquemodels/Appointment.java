package Cm.com.cliniquemodels;

import java.time.LocalTime;

public class Appointment 
{

	/*public Patient patient;
public Doctor doctor;
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}*/
	private int patientId,doctorId;
	private String patientName,doctorName;
	private String date;
	private LocalTime time;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Appointment [patientId=" + patientId + ", doctorId=" + doctorId + ", patientName=" + patientName
				+ ", doctorName=" + doctorName + ", date=" + date + ", time=" + time + "]";
	}
}