package com.oneToOneBidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private int pass_id;
	private String name;
	private String dob;
	private String citizen;
	@OneToOne(mappedBy = "pp")
	private Person p;
	
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public int getPass_id() {
		return pass_id;
	}
	public void setPass_id(int pass_id) {
		this.pass_id = pass_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCitizen() {
		return citizen;
	}
	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}
	@Override
	public String toString() {
		return "Passport [pass_id=" + pass_id + ", name=" + name + ", dob=" + dob + ", citizen=" + citizen + "]";
	}
	
	

}
