package com.oneToMany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {
		deleteStudent();
	}
	public static void insertStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College c=em.find(College.class, 1);
		List<Student> list = c.getStudent();
		Student s = new Student();
		s.setSid(106);
		s.setSname("Adam");
		s.setBranch("IT");
		list.add(s);
		
		c.setStudent(list);
		et.begin();
		em.persist(s); 
		et.commit();
	}
	
	
	//method to delete student
	//first delete it from college_student and then delete it from student 
	public static void deleteStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Query deleteQuery1 = em.createNativeQuery("Delete from College_student where student_sid=?1");
		deleteQuery1.setParameter(1, 101);
		
		Query deleteFromStudent = em.createNativeQuery("Delete from student where sid=?1");
		deleteFromStudent.setParameter(1, 101);
		
		et.begin();
		deleteQuery1.executeUpdate();
		deleteFromStudent.executeUpdate();
		et.commit();
	}
	
	public static void deleteCollege() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
	}

}
