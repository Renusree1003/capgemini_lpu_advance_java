package com.manyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Department d1 = new Department();
		//d1.setDept_id(1);
		d1.setDept_name("Analyst");
		d1.setManager_name("Driti");
		d1.setNoOfEmp(10);
		
		
		Employee e1 = new Employee();
		//e1.setEmp_id(1);
		e1.setName("Renu");
		e1.setDesignation("Btech");
		e1.setSalary(100000);
		e1.setDepartment(d1);
		
		Employee e2 = new Employee();
		//e2.setEmp_id(2);
		e2.setName("sree"); 
		e2.setDesignation("Btech");
		e2.setSalary(2000);
		e2.setDepartment(d1);
		
		et.begin();
		em.persist(d1);
		em.persist(e1);
		em.persist(e2);
		et.commit();
	}

}
