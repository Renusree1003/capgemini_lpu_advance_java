package com.crm_21stfeb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LeadService {
	public static void createLead(String source, String status) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Lead lead = new Lead();
		lead.setSource("Online");
		lead.setStatus("Paid");
		
		et.begin();
		em.persist(lead);
		et.commit();
		System.out.println("Lead created");
	}
	
	public static void assignLead(Long leadId, Long empId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Lead lead = em.find(Lead.class, leadId);
		SalesEmployee emp = em.find(SalesEmployee.class, empId);
		et.begin();
		lead.setEmployee(emp);
		et.commit();
		System.out.println("lead assigned");
	}

}
