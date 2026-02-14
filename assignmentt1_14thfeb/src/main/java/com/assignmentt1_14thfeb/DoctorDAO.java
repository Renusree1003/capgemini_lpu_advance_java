package com.assignmentt1_14thfeb;



import javax.persistence.*;

public class DoctorDAO {

    private EntityManager em;

    public DoctorDAO(EntityManager em) {
        this.em = em;
    }

    public void saveDoctor(Doctor d) {
        em.persist(d);
    }

    public Doctor findDoctor(int id) {
        return em.find(Doctor.class, id);
    }
}

