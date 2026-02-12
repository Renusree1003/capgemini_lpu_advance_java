package com.student;

import java.util.List;
import javax.persistence.*;

public class StudentDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // SAVE
    public String saveStudent(Student student) {
        if (student == null)
            return "Illegal Argument";

        et.begin();
        em.persist(student);
        et.commit();
        return "Student saved";
    }

    // FIND BY ID
    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    // FIND ALL
    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    // UPDATE
    public String updateStudent(int id, int newMarks) {
        Student s = em.find(Student.class, id);
        if (s == null)
            return "Student not found";

        et.begin();
        s.setMarks(newMarks);
        em.merge(s);
        et.commit();
        return "Student updated";
    }

    // DELETE
    public String deleteStudent(int id) {
        Student s = em.find(Student.class, id);
        if (s == null)
            return "Student not found";

        et.begin();
        em.remove(s);
        et.commit();
        return "Student deleted";
    }

    // COUNT
    public long getStudentCount() {
        return em.createQuery("SELECT COUNT(s) FROM Student s", Long.class)
                .getSingleResult();
    }

    // BONUS: Marks > 80
    public List<Student> findStudentsWithHighMarks() {
        return em.createQuery("SELECT s FROM Student s WHERE s.marks > 80",
                Student.class).getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
