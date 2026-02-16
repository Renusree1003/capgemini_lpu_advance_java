package com.manyToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql1 = "delete from student_subject where subject_sub_id=?1";
		Query deleteQuery1 = em.createNativeQuery(sql1);
		
		String sql2 = "delete from subject where sub_id=?1";
		Query deleteQuery2 = em.createNativeQuery(sql2);
		deleteQuery1.setParameter(1, 101);
		deleteQuery2.setParameter(1, 101);
		
		et.begin();
		deleteQuery1.executeUpdate();
		deleteQuery2.executeUpdate();
		et.commit();
	}

}
