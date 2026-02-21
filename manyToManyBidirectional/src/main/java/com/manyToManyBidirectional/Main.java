package com.manyToManyBidirectional;
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
		List<Student> li = new ArrayList<>();
		
		//List<Student> stu = List.of(s1,s2)  //---> Immutable way of creating list
		
		
		Student s1 = new Student();
		//s.setSid(1);
		s1.setName("Renu");
		s1.setGender("Female");
		s1.setBranch("CSE");
		s1.setSubject(list);
		
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
		sub1.setStudent(li);
		sub1.setStudent(li);
		sub1.setStudent(li);
		
		Subject sub2 = new Subject();
		sub2.setSub_id(102);
		sub2.setName("SQL");
		sub2.setNoOfDays(10);
		sub2.setStudent(li);
		sub2.setStudent(li);
		sub2.setStudent(li);
		
		Subject sub3 = new Subject();
		sub3.setSub_id(103);
		sub3.setName("PYTHON");
		sub3.setNoOfDays(40);
		sub3.setStudent(li);
		sub3.setStudent(li);
		sub3.setStudent(li);
		
		//List<Student> stu = List.of(s1,s2);  //---> Immutable way of creating list
				
		
		list.add(sub1);
		list.add(sub2);
		list.add(sub3);
		//s.setSubject(list);
		li.add(s1);
		li.add(s2);
		et.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(sub1);
		em.persist(sub2);
		em.persist(sub3);
		et.commit();
	}

}

