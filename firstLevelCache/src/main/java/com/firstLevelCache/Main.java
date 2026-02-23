package com.firstLevelCache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		//insert();
		read();
	}
	
	public static void insert() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("Pen");
		et.begin();
		em.persist(p1);
		et.commit();
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setName("Book");
		et.begin();
		em.persist(p2);
		et.commit();
		
		
		
	}
	
	public static void read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em1 = emf.createEntityManager();
		EntityTransaction et = em1.getTransaction();
		
		System.out.println("---FIRST CACHE-----");
		Product p1 = em1.find(Product.class, 1);
		System.out.println(p1.getName());
		em1.close();
		
		System.out.println("---SECOND CACHE---");
		EntityManager em2 = emf.createEntityManager();
		Product p2 = em2.find(Product.class, 1);
		System.out.println(p2.getName());
		em2.close();
	}

}
