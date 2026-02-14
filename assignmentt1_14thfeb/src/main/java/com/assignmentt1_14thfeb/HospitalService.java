package com.assignmentt1_14thfeb;



import javax.persistence.*;
import java.util.*;

public class HospitalService {

    private EntityManager em;
    private PatientDAO patientDAO;
    private DoctorDAO doctorDAO;
    private AppointmentDAO appointmentDAO;

    public HospitalService(EntityManager em) {
        this.em = em;
        this.patientDAO = new PatientDAO(em);
        this.doctorDAO = new DoctorDAO(em);
        this.appointmentDAO = new AppointmentDAO(em);
    }

    public void registerPatient(Patient p, MedicalRecord m) {
        em.getTransaction().begin();
        em.persist(m);
        p.setMedicalRecord(m);
        patientDAO.savePatient(p);
        em.getTransaction().commit();
    }

    public void addAppointmentsToDoctor(Doctor d, List<Appointment> list) {
        em.getTransaction().begin();
        for (Appointment a : list) {
            em.persist(a);
        }
        d.setAppointments(list);
        doctorDAO.saveDoctor(d);
        em.getTransaction().commit();
    }

    public void assignAppointmentToPatient(int appointmentId, int patientId) {

        em.getTransaction().begin();

        Appointment appointment = em.find(Appointment.class, appointmentId);
        Patient patient = em.find(Patient.class, patientId);

        appointment.setPatient(patient);

        em.getTransaction().commit();
    }


    public void updateAppointmentFee(int id, double fee) {
        em.getTransaction().begin();
        appointmentDAO.updateFee(id, fee);
        em.getTransaction().commit();
    }

    public Doctor fetchDoctor(int id) {
        return doctorDAO.findDoctor(id);
    }

    public void deletePatient(int id) {
        em.getTransaction().begin();
        patientDAO.deletePatient(id);
        em.getTransaction().commit();
    }
}

