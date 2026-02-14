package com.assignmentt1_14thfeb;



import javax.persistence.*;

public class PatientDAO {

    private EntityManager em;

    public PatientDAO(EntityManager em) {
        this.em = em;
    }

    public void savePatient(Patient p) {
        em.persist(p);
    }

    public Patient findPatient(int id) {
        return em.find(Patient.class, id);
    }

    public void updatePatient(Patient p) {
        em.merge(p);
    }

    public void deletePatient(int id) {
        Patient p = em.find(Patient.class, id);
        em.remove(p);
    }
}

