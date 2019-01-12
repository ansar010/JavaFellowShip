package Cm.com.cliniquemodels;

public class Doctor 
{

	private String name,specialization;
	private int id,numberOfPatient;
	private String availability;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public int getNumberOfPatient() {
		return numberOfPatient;
	}
	public void setNumberOfPatient(int numberOfPatient) {
		this.numberOfPatient = numberOfPatient;
	}
	public String toString() {
		return "Doctor [name=" + name + ", specialization=" + specialization + ", id=" + id + ", numberOfPatient="
				+ numberOfPatient + ", availability=" + availability + "]";
	}
}