package com.assignment3_14thfeb;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {

    private EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }

    // to Save User
    public void saveUser(User user) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
    }

    // to Find User
    public User findUser(int id) {
        return em.find(User.class, id);
    }

    // to Update User
    public void updateUser(User user) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
    }

    // to Delete User
    public void deleteUser(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }

        et.commit();
    }
}
