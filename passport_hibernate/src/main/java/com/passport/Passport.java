package com.passport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passport {
	@Id
	private int passportNo;
	private String name;
	private String gender;
	private String address;
	private int noOfTravels;
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNoOfTravels() {
		return noOfTravels;
	}
	public void setNoOfTravels(int noOfTravels) {
		this.noOfTravels = noOfTravels;
	}
	Passport(){
		
	}

}
