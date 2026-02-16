package com.oneToOneBidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id;
	private String name;
	private String phoneNo;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Passport pp;
	
	
	public Passport getPp() {
		return pp;
	}
	public void setPp(Passport pp) {
		this.pp = pp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	

}
