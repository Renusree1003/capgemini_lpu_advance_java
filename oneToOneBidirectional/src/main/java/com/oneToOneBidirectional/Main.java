package com.oneToOneBidirectional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("Renu");
		p1.setEmail("Renu@gmail.com");
		p1.setPhoneNo("123456789");
	
		
		Passport pp1 = new Passport();
		pp1.setPass_id(101);
		pp1.setName("Renusree");
		pp1.setDob("10-MAR");
		pp1.setCitizen("Indian");
		pp1.setP(p1);
		p1.setPp(pp1);
		
		et.begin();
		//em.persist(pp1);
		em.persist(p1);
		et.commit();
		
		
		
	
	}

}
