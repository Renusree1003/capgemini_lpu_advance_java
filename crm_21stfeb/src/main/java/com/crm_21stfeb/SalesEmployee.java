package com.crm_21stfeb;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesEmployee {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long empId;
	private String name;
	private String department;
	@OneToMany(mappedBy = "employee")
	private List<Lead> lead;
	
	public List<Lead> getLead() {
		return lead;
	}
	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
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
		return "SalesEmployee [empId=" + empId + ", name=" + name + ", department=" + department + "]";
	}
	

}
