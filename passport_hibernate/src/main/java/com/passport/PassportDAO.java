package com.passport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PassportDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // ---------------- INSERT ----------------
    public String insert(Passport passport) {

        if (passport == null) {
            return "Illegal Argument";
        }

        et.begin();
        em.persist(passport);
        et.commit();
        return "Passport inserted";
    }

    // ---------------- FIND ----------------
    public Passport find(int passportNo) {
        return em.find(Passport.class, passportNo);
    }

    // ---------------- UPDATE ----------------
    public String update(int passportNo, String newAddress, int newTravels) {

        Passport p = em.find(Passport.class, passportNo);

        if (p == null) {
            return "Passport not found";
        }

        et.begin();
        p.setAddress(newAddress);
        p.setNoOfTravels(newTravels);
        em.merge(p);
        et.commit();

        return "Passport updated";
    }

    // ---------------- DELETE ----------------
    public String delete(int passportNo) {

        Passport p = em.find(Passport.class, passportNo);

        if (p == null) {
            return "Passport not found";
        }

        et.begin();
        em.remove(p);
        et.commit();

        return "Passport deleted";
    }

    // ---------------- FIND ALL ----------------
    public List<Passport> findAll() {
        TypedQuery<Passport> query =
                em.createQuery("SELECT p FROM Passport p", Passport.class);
        return query.getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
