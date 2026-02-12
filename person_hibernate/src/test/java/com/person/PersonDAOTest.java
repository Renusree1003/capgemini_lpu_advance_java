package com.person;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonDAOTest {

    static EntityManagerFactory emf;
    EntityManager em;

    @BeforeAll
    public static void initEmf() {
        System.out.println("Init EMF");
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    public void initEm() {
        em = emf.createEntityManager();
    }

    // ---------------- INSERT SUCCESS ----------------
    @Test
    public void insertPersonTest() {
        PersonDAO dao = new PersonDAO();

        Person person = new Person();
        person.setId(100);
        person.setName("Submi");
        person.setDob("2002-05-10");
        person.setAddress("Hyderabad");
        person.setPincode(500001);

        String result = dao.insert(person);
        assertEquals("Person inserted", result);
    }

    // ---------------- INSERT NULL ----------------
    @Test
    public void insertPersonNullTest() {
        PersonDAO dao = new PersonDAO();

        String result = dao.insert(null);
        assertEquals("Illegal Argument", result);
    }

    // ---------------- FIND SUCCESS ----------------
    @Test
    public void findPersonTest() {
        PersonDAO dao = new PersonDAO();

        Person person = dao.find(100);
        assertNotNull(person);
    }

    // ---------------- FIND NOT FOUND ----------------
    @Test
    public void findPersonNotFoundTest() {
        PersonDAO dao = new PersonDAO();

        Person person = dao.find(9999);
        assertNull(person);
    }

    // ---------------- UPDATE SUCCESS ----------------
    @Test
    public void updatePersonTest() {
        PersonDAO dao = new PersonDAO();

        String result = dao.update(100, "Bangalore", 560001);
        assertEquals("Person updated", result);
    }

    // ---------------- UPDATE NOT FOUND ----------------
    @Test
    public void updatePersonNotFoundTest() {
        PersonDAO dao = new PersonDAO();

        String result = dao.update(9999, "Delhi", 110001);
        assertEquals("Person not found", result);
    }

    // ---------------- DELETE SUCCESS ----------------
    @Test
    public void deletePersonTest() {
        PersonDAO dao = new PersonDAO();

        String result = dao.delete(100);
        assertEquals("Person deleted", result);
    }

    // ---------------- DELETE NOT FOUND ----------------
    @Test
    public void deletePersonNotFoundTest() {
        PersonDAO dao = new PersonDAO();

        String result = dao.delete(9999);
        assertEquals("Person not found", result);
    }

    // ---------------- FIND ALL ----------------
    @Test
    public void findAllPersonsTest() {
        PersonDAO dao = new PersonDAO();

        List<Person> list = dao.findAll();
        assertNotNull(list);
    }

    @AfterEach
    public void destroyEm() {
        em.close();
    }

    @AfterAll
    public static void destroyEmf() {
        emf.close();
    }
}
