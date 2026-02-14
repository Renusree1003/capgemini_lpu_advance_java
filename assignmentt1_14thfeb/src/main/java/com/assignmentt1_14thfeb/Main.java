package com.assignmentt1_14thfeb;



import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        HospitalService service = new HospitalService(em);

        // -------- Register Patient --------
        MedicalRecord record = new MedicalRecord();
        record.setMedical_id(1);
        record.setBlood_group("O+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setPatient_id(1);
        patient.setName("Renu");
        patient.setAge(20);
        patient.setContact("1234567890");

        service.registerPatient(patient, record);

        // -------- Add Doctor & Appointments --------
        Appointment a1 = new Appointment();
        a1.setAppointment_id(101);
        a1.setVisitDate("14-02-26");
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setAppointment_id(102);
        a2.setVisitDate("16-02-26");
        a2.setFee(600);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(1);
        doctor.setDoctor_name("Dr.Driti");
        doctor.setSpecialization("Dentist");

        List<Appointment> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        service.addAppointmentsToDoctor(doctor, list);

        // -------- Assign Appointment to Patient --------
        service.assignAppointmentToPatient(101, 1);

        // -------- Update Fee --------
        service.updateAppointmentFee(101, 700);

        // -------- Fetch Doctor --------
        Doctor fetchedDoctor = service.fetchDoctor(1);
        System.out.println(fetchedDoctor);
        System.out.println(fetchedDoctor.getAppointments());

        // -------- Delete Patient --------
        service.deletePatient(1);
    }
}

