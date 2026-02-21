package com.crm_21stfeb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ReportService {
	public static void getOrdersByCustomer(Long customerId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "Select o From order o where o.customer.customerId = :cid";
		List<Order> orders= em.createQuery(jpql, Order.class)
				.setParameter("cid", customerId).getResultList();
		
		for(Order o : orders) {
			System.out.println(o);
		}
	}
	
	public static void getLeadsByEmployee(Long empId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String jpql = "select l from Lead where l.employee.empId = :eid";
		List<Lead> leads = em.createQuery(jpql, Lead.class)
				.setParameter("eid", empId).getResultList();
		
		for(Lead l : leads) {
			System.out.println(l);
		}
	}

}
