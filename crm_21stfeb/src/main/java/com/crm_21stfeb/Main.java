package com.crm_21stfeb;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		CustomerService.registerCustomer("Renu", "renu@gmail.com", "987654321");
		//CustomerService.addAddress(1L, "Ananthapur", "Andhra Pradesh", "515511");
		
		
		//ProductService.addProduct("Phone", 20000);
		
		//LeadService.createLead("Website", "New");
		
		//LeadService.assignLead(1L, 1L);
		
		List<Long> productIds = new ArrayList<>();
		
		productIds.add(1L);
		productIds.add(2L);
		
		//OrderService.placeOrder(1L, productIds, "21-02-2026");
		
		//TicketService.raiseTicket(1L, "Delivery delay", "open");
		
		//ReportService.getLeadsByEmployee(1L);
		//ReportService.getOrdersByCustomer(1L);
		
	}

}
