package com.fintech_23rdfeb;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankAccountDAO {

    public void save(BankAccount account) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(account);
        et.commit();

        em.close();
        emf.close();
    }

    public void linkToCustomer(Long accountId, Long customerId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        BankAccount account = em.find(BankAccount.class, accountId);
        Customer customer = em.find(Customer.class, customerId);

        account.setCustomer(customer);
        customer.setBankAccount(account);

        et.commit();

        em.close();
        emf.close();
    }
  

    public List<BankAccount> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        List<BankAccount> list =
                em.createQuery("SELECT b FROM BankAccount b", BankAccount.class)
                        .getResultList();

        em.close();
        emf.close();

        return list;
    }
    
}
