package com.assignmentt1_14thfeb;



import javax.persistence.*;
import java.util.List;

public class AppointmentDAO {

    private EntityManager em;

    public AppointmentDAO(EntityManager em) {
        this.em = em;
    }

    public void saveAppointment(Appointment a) {
        em.persist(a);
    }

    public List<Appointment> findAppointmentByDoctor(int doctorId) {
        Doctor d = em.find(Doctor.class, doctorId);
        return d.getAppointments();
    }

    public void updateFee(int id, double newFee) {
        Appointment a = em.find(Appointment.class, id);
        a.setFee(newFee);
    }
}

