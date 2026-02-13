package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		//saveAadhar();
		//saveHostelRoom();
		//createStudent();
		fetchStudent();
		//deleteStudent();

	}

	// method to save aadhar details
	public static void saveAadhar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		AadharCard ac = new AadharCard();
		ac.setAadharId(101);
		ac.setAadharNumber("123-456-789");
		ac.setAddress("Ananthapur");
		ac.setIssueDate("10-mar-2010");

		et.begin();
		em.persist(ac);
		et.commit();
	}

	//method to save hostel details
	public static void saveHostelRoom() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		HostelRoom hr = new HostelRoom();
		hr.setRoomId(201);
		hr.setRoomNumber("B-443");
		hr.setBlockName("Block-B");
		hr.setFloorNumber(6);
		et.begin();
		em.persist(hr);
		et.commit();
	}

	
	//method to create student details
	public static void createStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		AadharCard ac = em.find(AadharCard.class, 101);
		HostelRoom hr = em.find(HostelRoom.class, 201);

		Student s = new Student();
		s.setStudentId(1);
		s.setName("Renu");
		s.setEmail("renu@gmail.com");
		s.setBranch("CSE");
		s.setAadharCard(ac);
		s.setHostelRoom(hr);
		et.begin();
		em.persist(s);
		et.commit();
	}

	
	//method to fetch student details
	public static void fetchStudent() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();

		Student s = em.find(Student.class, 1);

		System.out.println(s);
		System.out.println("Aadhar Number: " + s.getAadharCard().getAadharNumber());
		System.out.println("Room Number: " + s.getHostelRoom().getRoomNumber());
	}

	
	//method to delete student
	public static void deleteStudent() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student s = em.find(Student.class, 1);

		et.begin();
		em.remove(s);
		et.commit();
	}

}
