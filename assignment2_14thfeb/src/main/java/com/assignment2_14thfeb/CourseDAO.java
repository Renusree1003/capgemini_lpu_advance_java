package com.assignment2_14thfeb;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    private EntityManager em;

    public CourseDAO(EntityManager em) {
        this.em = em;
    }

    public void saveCourse(Course course) {
        em.persist(course);
    }

    public Course findCourse(int id) {
        return em.find(Course.class, id);
    }

    public List<Course> findByInstructor(int instructorId) {
        Instructor instructor = em.find(Instructor.class, instructorId);
        return instructor.getCourses();
    }
}
