package com.assignmentt1_14thfeb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	private int appointment_id;
	private String visitDate;
	private double fee;
	
	@ManyToOne
	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id + ", visitDate=" + visitDate + ", fee=" + fee + "]";
	}
	
	
	

}
