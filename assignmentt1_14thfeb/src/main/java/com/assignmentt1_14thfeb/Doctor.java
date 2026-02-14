package com.assignmentt1_14thfeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	private int doctor_id;
	private String doctor_name;
	private String specialization;
	
	@OneToMany
	private List<Appointment> appointments = new ArrayList<>();
	
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Doctor [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", specialization=" + specialization
				+ "]";
	}
	
	

}
