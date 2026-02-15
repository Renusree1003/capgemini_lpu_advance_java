package com.assignment2_14thfeb;

import org.junit.jupiter.api.*;
import javax.persistence.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UniversityTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private UniversityService service;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        service = new UniversityService(em);
    }

    @Test
    
    void oneToOneTest() {

        InstructorProfile profile = new InstructorProfile();
        profile.setInstructorProfile_id(10);
        profile.setOfficeRoom("B-201");
        profile.setPhone("123456789");

        Instructor instructor = new Instructor();
        instructor.setId(10);
        instructor.setName("Mr.Neha");
        instructor.setDepartment("IT");

        service.createInstructorWithProfile(instructor, profile);

        assertNotNull(service.fetchInstructor(10));
    }

    @Test
   
    void oneToManyTest() {

        Instructor instructor = service.fetchInstructor(10);

        Course c = new Course();
        c.setCourse_id(300);
        c.setTitle("Java");
        c.setCredits(4);

        service.addCoursesToInstructor(instructor, Arrays.asList(c));

        assertEquals(1,
                service.fetchInstructor(10).getCourses().size());
    }

    @Test
    
    void manyToOneTest() {

        Enrollment e = new Enrollment();
        e.setEnrollment_id(400);
        e.setSemester("SEM- 8");
        e.setGrade('A');

        service.addEnrollmentToCourse(300, e);

        assertNotNull(e);
    }
}
