package com.crm_21stfeb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerService {
	
	//metod to register customer
	public static void registerCustomer(String name, String email, String phone) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Customer customer = new Customer();
	customer.setName("Renu");
	customer.setEmail("renu@gmail.com");
	customer.setPhone("987654321");
	
	et.begin();
	em.persist(customer);
	et.commit();
	System.out.println("customer registered");
	
	
	
	}
	
	//method to add address
	public static void addAddress(Long customerId,String city, String state, String zip) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, customerId);
		Address address = new Address();
		address.setCity("Ananthapur");
		address.setState("Andhra Pradesh");
		address.setPincode("515511");
		
		
		et.begin();
		customer.setAdddress(address);
		em.persist(address);
		et.commit();
		
		System.out.println("Address added");
	}

}
