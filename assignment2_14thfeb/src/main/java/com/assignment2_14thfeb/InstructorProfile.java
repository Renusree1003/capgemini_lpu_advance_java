package com.assignment2_14thfeb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InstructorProfile {
	@Id
	private int instructorProfile_id;
	private String officeRoom;
	private String phone;
	public int getInstructorProfile_id() {
		return instructorProfile_id;
	}
	public void setInstructorProfile_id(int instructorProfile_id) {
		this.instructorProfile_id = instructorProfile_id;
	}
	public String getOfficeRoom() {
		return officeRoom;
	}
	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
