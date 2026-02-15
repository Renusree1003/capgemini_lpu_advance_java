package com.assignment2_14thfeb;

import javax.persistence.EntityManager;

public class EnrollmentDAO {

    private EntityManager em;

    public EnrollmentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveEnrollment(Enrollment enrollment) {
        em.persist(enrollment);
    }

    public void updateGrade(int enrollmentId, char grade) {
        Enrollment enrollment = em.find(Enrollment.class, enrollmentId);
        enrollment.setGrade(grade);
    }
}
