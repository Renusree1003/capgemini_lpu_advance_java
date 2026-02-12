package com.person;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class PersonDAO {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    
	    public String insert(Person person) {
	        et.begin();
	        em.persist(person);
	        et.commit();
	        //System.out.println("Person inserted successfully");
	        return "Person inserted";
	    }
	    
	    
	    public String delete(int id) {
	        Person p = em.find(Person.class, id);

	        if (p != null) {
	            et.begin();
	            em.remove(p);
	            et.commit();
	            //System.out.println("Person deleted successfully");
	            return "Person deleted";
	        } else {
	            //System.out.println("Person not found");
	            return "Person not found";
	        }
	    }
	    
	    
	    
	    public String update(int id, String newAddress, int newPincode) {
	        Person p = em.find(Person.class, id);

	        if (p != null) {
	            et.begin();
	            p.setAddress(newAddress);
	            p.setPincode(newPincode);
	            em.merge(p);
	            et.commit();
	            //System.out.println("Person updated successfully");
	            return "Person not found";
	        } else {
	            //System.out.println("Person not found");
	            return "Person updated";
	        }
	    }
	    
	    
	    
	    public Person find(int id) {
	        Person p = em.find(Person.class, id);

	        if (p != null) {
	            return p;
	        } else {
	            System.out.println("Person not found");
	            return null;
	        }
	    }
	    
	    
	    public List<Person> findAll() {
	        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
	        return query.getResultList();
	    }
	    
	    
	    public void close() {
	        em.close();
	        emf.close();
	    }

	}




