package com.crm_21stfeb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Lead {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long leadId;
	private String source;
	private String status;
	@ManyToOne
	@JoinColumn
	private SalesEmployee employee;
	
	@OneToOne
	@JoinColumn
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public SalesEmployee getEmployee() {
		return employee;
	}
	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}
	public Long getLeadId() {
		return leadId;
	}
	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Lead [leadId=" + leadId + ", source=" + source + ", status=" + status + "]";
	}
	

}
