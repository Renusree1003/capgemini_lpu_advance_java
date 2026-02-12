package com.student;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import javax.persistence.*;

import org.junit.jupiter.api.*;

public class StudentDAOTest {

    static EntityManagerFactory emf;
    EntityManager em;

    @BeforeAll
    public static void initEmf() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    public void initEm() {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveStudent() {
        StudentDAO dao = new StudentDAO();

        Student s = new Student();
        s.setName("TestUser");
        s.setEmail("test@mail.com");
        s.setMarks(75);

        assertEquals("Student saved", dao.saveStudent(s));
    }

    @Test
    public void testFindStudentById() {
        StudentDAO dao = new StudentDAO();
        Student s = dao.findStudentById(1);
        assertNotNull(s);
    }

    @Test
    public void testFindAllStudents() {
        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.findAllStudents();
        assertNotNull(list);
    }

    @Test
    public void testUpdateStudent() {
        StudentDAO dao = new StudentDAO();
        assertEquals("Student updated", dao.updateStudent(1, 88));
    }

    @Test
    public void testDeleteStudent() {
        StudentDAO dao = new StudentDAO();
        assertEquals("Student deleted", dao.deleteStudent(1));
    }

    @Test
    public void testStudentCount() {
        StudentDAO dao = new StudentDAO();
        long count = dao.getStudentCount();
        assertTrue(count >= 0);
    }

    @Test
    public void testHighMarksQuery() {
        StudentDAO dao = new StudentDAO();
        List<Student> list = dao.findStudentsWithHighMarks();
        assertNotNull(list);
    }

    @AfterEach
    public void closeEm() {
        em.close();
    }

    @AfterAll
    public static void closeEmf() {
        emf.close();
    }
}
