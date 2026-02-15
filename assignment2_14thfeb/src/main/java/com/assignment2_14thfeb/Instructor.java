package com.assignment2_14thfeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Instructor {
	@Id
	private int id;
	private String name;
	private String department;
	
	@OneToOne
	private InstructorProfile instructorProfile;
	
	@OneToMany
	private List<Course> courses = new ArrayList<>();
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public InstructorProfile getInstructorProfile() {
		return instructorProfile;
	}
	public void setInstructorProfile(InstructorProfile instructorProfile) {
		this.instructorProfile = instructorProfile;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	
	
	

}
