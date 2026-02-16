package com.assignment1_16thfeb;

import javax.persistence.*;

public class UsersDAO {

    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    // Save User
    public void saveUser(Users user) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
    }

    // Find User
    public Users findUser(int id) {
        return em.find(Users.class, id);
    }

    // Update User
    public void updateUser(Users user) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(user);
        et.commit();
    }

    // Delete User
    public void deleteUser(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        Users user = em.find(Users.class, id);
        if (user != null) {
            em.remove(user);
        }

        et.commit();
    }
}
