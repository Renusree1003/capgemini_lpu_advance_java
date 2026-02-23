package com.fintech_23rdfeb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDAO {

	public void save(Customer customer) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(customer);
		et.commit();

		em.close();
		emf.close();
	}

	public Customer findById(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();

		Customer customer = em.find(Customer.class, id);

		em.close();
		emf.close();

		return customer;
	}

	public List<Customer> findAll() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();

		List<Customer> list = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();

		em.close();
		emf.close();

		return list;
	}

	public void delete(Long id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Customer customer = em.find(Customer.class, id);
		em.remove(customer);

		et.commit();

		em.close();
		emf.close();
	}
}
