package com.assignment2_14thfeb;

import javax.persistence.EntityManager;

public class InstructorDAO {

    private EntityManager em;

    public InstructorDAO(EntityManager em) {
        this.em = em;
    }

    public void saveInstructor(Instructor instructor) {
        em.persist(instructor);
    }

    public Instructor findInstructor(int id) {
        return em.find(Instructor.class, id);
    }

    public void updateInstructor(Instructor instructor) {
        em.merge(instructor);
    }

    public void deleteInstructor(int id) {
        Instructor instructor = em.find(Instructor.class, id);
        em.remove(instructor);
    }
}
