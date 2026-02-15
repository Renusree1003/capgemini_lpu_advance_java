package com.assignment2_14thfeb;

import javax.persistence.*;
import java.util.*;

public class UniversityService {

    private EntityManager em;
    private InstructorDAO instructorDAO;
    private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;

    public UniversityService(EntityManager em) {
        this.em = em;
        this.instructorDAO = new InstructorDAO(em);
        this.courseDAO = new CourseDAO(em);
        this.enrollmentDAO = new EnrollmentDAO(em);
    }

    // To Create instructor profile
    public void createInstructorWithProfile(Instructor instructor, InstructorProfile profile) {

        em.getTransaction().begin();

        em.persist(profile);
        instructor.setInstructorProfile(profile);
        instructorDAO.saveInstructor(instructor);

        em.getTransaction().commit();
    }

    // multiple courses to instructor
    public void addCoursesToInstructor(Instructor instructor, List<Course> courses) {

        em.getTransaction().begin();

        for (Course c : courses) {
            em.persist(c);
        }

        instructor.setCourses(courses);
        instructorDAO.saveInstructor(instructor);

        em.getTransaction().commit();
    }

    // Add enrollment to course
    public void addEnrollmentToCourse(int courseId, Enrollment enrollment) {

        em.getTransaction().begin();

        Course course = em.find(Course.class, courseId);
        enrollment.setCourse(course);
        enrollmentDAO.saveEnrollment(enrollment);

        em.getTransaction().commit();
    }

    // Update enrollment grade
    public void updateEnrollmentGrade(int enrollmentId, char grade) {

        em.getTransaction().begin();
        enrollmentDAO.updateGrade(enrollmentId, grade);
        em.getTransaction().commit();
    }

    // Fetch instructor with courses
    public Instructor fetchInstructor(int instructorId) {
        return instructorDAO.findInstructor(instructorId);
    }

    // Delete instructor
    public void deleteInstructor(int instructorId) {

        em.getTransaction().begin();
        instructorDAO.deleteInstructor(instructorId);
        em.getTransaction().commit();
    }
}
