package com.assignment2_14thfeb;

import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        UniversityService service = new UniversityService(em);

        // -------- Create Instructor + Profile --------
        InstructorProfile profile = new InstructorProfile();
        profile.setInstructorProfile_id(1);
        profile.setOfficeRoom("A-101");
        profile.setPhone("987654321");

        Instructor instructor = new Instructor();
        instructor.setId(1);
        instructor.setName("Mr.rohith");
        instructor.setDepartment("Computer Science");

        service.createInstructorWithProfile(instructor, profile);

        // -------- Add Courses --------
        Course c1 = new Course();
        c1.setCourse_id(101);
        c1.setTitle("Hibernate");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setCourse_id(102);
        c2.setTitle("Spring Boot");
        c2.setCredits(3);

        service.addCoursesToInstructor(instructor, Arrays.asList(c1, c2));

        // -------- Add Enrollment --------
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollment_id(201);
        enrollment.setSemester("SEM-8");
        enrollment.setGrade('A');

        service.addEnrollmentToCourse(101, enrollment);

        // -------- Update Grade --------
        service.updateEnrollmentGrade(201, 'B');

        // -------- Fetch Instructor --------
        Instructor fetched = service.fetchInstructor(1);
        System.out.println(fetched);
        System.out.println(fetched.getCourses());

        // -------- Delete Instructor --------
        service.deleteInstructor(1);
    }
}
