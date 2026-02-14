package com.assignmentt1_14thfeb;

import org.junit.jupiter.api.*;
import javax.persistence.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HospitalTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private HospitalService service;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        service = new HospitalService(em);
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

   //one to one persist test
    @Test
   
    void oneToOnePersistTest() {

        MedicalRecord record = new MedicalRecord();
        record.setMedical_id(12);
        record.setBlood_group("A+");
        record.setAllergies("Dust");

        Patient patient = new Patient();
        patient.setPatient_id(12);
        patient.setName("Virat");
        patient.setAge(35);
        patient.setContact("987654321");

        service.registerPatient(patient, record);

        Patient saved = em.find(Patient.class, 12);

        assertNotNull(saved);
        assertEquals("A+", saved.getMedicalRecord().getBlood_group());
    }

   //one to many persist test
    @Test
   
    void oneToManyPersistTest() {

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(22);
        doctor.setDoctor_name("Dr.Rohith");
        doctor.setSpecialization("Neurology");

        Appointment a1 = new Appointment();
        a1.setAppointment_id(203);
        a1.setVisitDate("2026-02-15");
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setAppointment_id(204);
        a2.setVisitDate("2026-02-16");
        a2.setFee(600);

        List<Appointment> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);

        service.addAppointmentsToDoctor(doctor, list);

        Doctor savedDoctor = em.find(Doctor.class, 22);

        assertNotNull(savedDoctor);
        assertEquals(2, savedDoctor.getAppointments().size());
    }

    //many to one persist test
    
    @Test
    
    void manyToOnePersistTest() {

        Patient patient = em.find(Patient.class, 12);

        Appointment appointment = new Appointment();
        appointment.setAppointment_id(302);
        appointment.setVisitDate("2026-02-18");
        appointment.setFee(800);

        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();

        service.assignAppointmentToPatient(302, 12);

        Appointment saved = em.find(Appointment.class, 302);

        assertNotNull(saved.getPatient());
        assertEquals("Rohith", saved.getPatient().getName());
    }

   
    //update test
    @Test
    
    void updateFeeTest() {

        service.updateAppointmentFee(302, 1000);

        Appointment updated = em.find(Appointment.class, 302);

        assertEquals(1000, updated.getFee());
    }

    
    //delete test
    @Test
    
    void deletePatientTest() {

        service.deletePatient(12);

        Patient deleted = em.find(Patient.class, 12);

        assertNull(deleted);
    }

    
    @Test
   
    void fullWorkflowTest() {

        MedicalRecord record = new MedicalRecord();
        record.setMedical_id(51);
        record.setBlood_group("B+");
        record.setAllergies("None");

        Patient patient = new Patient();
        patient.setPatient_id(51);
        patient.setName("Renu");
        patient.setAge(22);
        patient.setContact("8908756393");

        service.registerPatient(patient, record);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(61);
        doctor.setDoctor_name("Dr. Hithesh");
        doctor.setSpecialization("Cardiology");

        Appointment appointment = new Appointment();
        appointment.setAppointment_id(601);
        appointment.setVisitDate("2026-03-01");
        appointment.setFee(1500);

        List<Appointment> list = new ArrayList<>();
        list.add(appointment);

        service.addAppointmentsToDoctor(doctor, list);

        service.assignAppointmentToPatient(601, 51);

        Doctor fetched = service.fetchDoctor(61);

        assertEquals(1, fetched.getAppointments().size());
    }
}
