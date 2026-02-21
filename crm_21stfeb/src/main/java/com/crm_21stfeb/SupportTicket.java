package com.crm_21stfeb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SupportTicket {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ticketId;
	private String issue;
	private String status;
	@OneToOne
	@JoinColumn
	private Order order;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SupportTicket [ticketId=" + ticketId + ", issue=" + issue + ", status=" + status + "]";
	}
	

}
