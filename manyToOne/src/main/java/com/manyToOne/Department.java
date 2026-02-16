package com.manyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="number_sequence")
	@SequenceGenerator(name="number_sequence",sequenceName="number_sequence",initialValue = 100,allocationSize = 1)
	private int dept_id;
	private String dept_name;
	private String Manager_name;
	private int noOfEmp;
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getManager_name() {
		return Manager_name;
	}
	public void setManager_name(String manager_name) {
		Manager_name = manager_name;
	}
	public int getNoOfEmp() {
		return noOfEmp;
	}
	public void setNoOfEmp(int noOfEmp) {
		this.noOfEmp = noOfEmp;
	}
	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", dept_name=" + dept_name + ", Manager_name=" + Manager_name
				+ ", noOfEmp=" + noOfEmp + "]";
	}
	
	

}
