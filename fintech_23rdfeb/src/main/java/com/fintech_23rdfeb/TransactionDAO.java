package com.fintech_23rdfeb;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TransactionDAO {

    public void save(Transaction txn, Long accountId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        BankAccount account = em.find(BankAccount.class, accountId);
        //account.addTransaction(txn);
        em.persist(txn);

        et.commit();

        em.close();
        emf.close();
    }

    public List<Transaction> findByAccount(Long accountId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        List<Transaction> list =
                em.createQuery(
                        "SELECT t FROM Transaction t WHERE t.bankAccount.accountId = :id",
                        Transaction.class)
                        .setParameter("id", accountId)
                        .getResultList();

        em.close();
        emf.close();

        return list;
    }
}