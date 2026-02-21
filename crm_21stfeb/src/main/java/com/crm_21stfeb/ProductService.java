package com.crm_21stfeb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductService {
	
	public static void addProduct(String name, double price) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Product product = new Product();
		product.setProductName("Phone");
		product.setPrice(20000);
		
		et.begin();
		em.persist(product);
		et.commit();
		
		System.out.println("Product added");
	}

}
