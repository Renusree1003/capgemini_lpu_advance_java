package com.manyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		List<Subject> list = new ArrayList<>();
		Student s = new Student();
		//s.setSid(1);
		s.setName("Renu");
		s.setGender("Female");
		s.setBranch("CSE");
		s.setSubject(list);
		
		Student s2 = new Student();
		//s.setSid(2);
		s2.setName("Driti");
		s2.setBranch("ECE");
		s2.setGender("Others");
		s2.setSubject(list);
		
		Subject sub1 = new Subject();
		sub1.setSub_id(101);
		sub1.setName("JAVA");
		sub1.setNoOfDays(25);
		
		Subject sub2 = new Subject();
		sub2.setSub_id(102);
		sub2.setName("SQL");
		sub2.setNoOfDays(10);
		
		Subject sub3 = new Subject();
		sub3.setSub_id(103);
		sub3.setName("PYTHON");
		sub3.setNoOfDays(40);
		
		
		list.add(sub1);
		list.add(sub2);
		list.add(sub3);
		//s.setSubject(list);
		et.begin();
		em.persist(s);
		em.persist(s2);
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		et.commit();
	}

}
