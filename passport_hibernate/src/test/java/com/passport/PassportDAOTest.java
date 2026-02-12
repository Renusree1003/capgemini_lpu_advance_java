package com.passport;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PassportDAOTest {

    static EntityManagerFactory emf;

    @BeforeAll
    public static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    // ---------------- INSERT SUCCESS ----------------
    @Test
    public void insertPassportTest() {
        PassportDAO dao = new PassportDAO();

        Passport p = new Passport();
        p.setPassportNo(100);
        p.setName("TestUser");
        p.setGender("Male");
        p.setAddress("Delhi");
        p.setNoOfTravels(2);

        String result = dao.insert(p);
        assertEquals("Passport inserted", result);
    }

    // ---------------- INSERT NULL ----------------
    @Test
    public void insertPassportNullTest() {
        PassportDAO dao = new PassportDAO();

        String result = dao.insert(null);
        assertEquals("Illegal Argument", result);
    }

    // ---------------- FIND SUCCESS ----------------
    @Test
    public void findPassportTest() {
        PassportDAO dao = new PassportDAO();

        Passport p = dao.find(100);
        assertNotNull(p);
    }

    // ---------------- FIND NOT FOUND ----------------
    @Test
    public void findPassportNotFoundTest() {
        PassportDAO dao = new PassportDAO();

        Passport p = dao.find(9999);
        assertNull(p);
    }

    // ---------------- UPDATE SUCCESS ----------------
    @Test
    public void updatePassportTest() {
        PassportDAO dao = new PassportDAO();

        String result = dao.update(100, "Mumbai", 5);
        assertEquals("Passport updated", result);
    }

    // ---------------- UPDATE NOT FOUND ----------------
    @Test
    public void updatePassportNotFoundTest() {
        PassportDAO dao = new PassportDAO();

        String result = dao.update(9999, "Chennai", 3);
        assertEquals("Passport not found", result);
    }

    // ---------------- DELETE SUCCESS ----------------
    @Test
    public void deletePassportTest() {
        PassportDAO dao = new PassportDAO();

        String result = dao.delete(100);
        assertEquals("Passport deleted", result);
    }

    // ---------------- DELETE NOT FOUND ----------------
    @Test
    public void deletePassportNotFoundTest() {
        PassportDAO dao = new PassportDAO();

        String result = dao.delete(9999);
        assertEquals("Passport not found", result);
    }

    // ---------------- FIND ALL ----------------
    @Test
    public void findAllPassportTest() {
        PassportDAO dao = new PassportDAO();

        List<Passport> list = dao.findAll();
        assertNotNull(list);
    }

    @AfterAll
    public static void destroy() {
        emf.close();
    }
}
