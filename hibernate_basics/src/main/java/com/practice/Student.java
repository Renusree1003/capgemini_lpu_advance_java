package com.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_info")
public class Student {
	
	@Id
	@Column(name="student_id")
	private int id;
	@Column(name="student_name")
	String name;
	@Column(name="student_percentage")
	double percentage;
	@Column(name="student_dob")
	private String dob;
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
	public double getPercentage() {
		return percentage;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
