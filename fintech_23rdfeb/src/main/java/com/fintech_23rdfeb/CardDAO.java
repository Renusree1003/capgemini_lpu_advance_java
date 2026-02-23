package com.fintech_23rdfeb;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CardDAO {

    public void issueCard(Card card, Long accountId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        BankAccount account = em.find(BankAccount.class, accountId);
        card.setBankAccount(account);

        em.persist(card);

        et.commit();

        em.close();
        emf.close();
    }

    public void assignCardToCustomer(Long cardId, Long customerId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Card card = em.find(Card.class, cardId);
        Customer customer = em.find(Customer.class, customerId);

        customer.getCards().add(card);

        et.commit();

        em.close();
        emf.close();
    }

    public List<Card> findAll() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();

        List<Card> list =
                em.createQuery("SELECT c FROM Card c", Card.class)
                        .getResultList();

        em.close();
        emf.close();

        return list;
    }

    public void deactivateCard(Long cardId) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        Card card = em.find(Card.class, cardId);
        card.setIsActive(false);

        et.commit();

        em.close();
        emf.close();
    }
}
