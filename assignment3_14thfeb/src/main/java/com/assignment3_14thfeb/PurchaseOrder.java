package com.assignment3_14thfeb;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	private int purchaseOrder_id;
	
	private String orderDate;
	private double totalAmount;
	public int getPurchaseOrder_id() {
		return purchaseOrder_id;
	}
	public void setPurchaseOrder_id(int purchaseOrder_id) {
		this.purchaseOrder_id = purchaseOrder_id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrder_id=" + purchaseOrder_id + ", orderDate=" + orderDate + ", totalAmount="
				+ totalAmount + "]";
	}
	

}
