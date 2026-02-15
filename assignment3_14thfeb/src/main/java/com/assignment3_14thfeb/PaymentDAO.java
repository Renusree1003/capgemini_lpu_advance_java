package com.assignment3_14thfeb;

import javax.persistence.*;

public class PaymentDAO {

    private EntityManager em;

    public PaymentDAO(EntityManager em) {
        this.em = em;
    }

    public void savePayment(Payment payment) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(payment);
        et.commit();
    }

    public Payment findPayment(int id) {
        return em.find(Payment.class, id);
    }
}
