package com.oneToOneBidirectional;

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
		
//		String sql1 = "update Person set pp_pass_id = null where id=?1";
//		
//		String sql2 = "delete from passport where pass_id = ?1";
//		
//		Query updateQuery = em.createNativeQuery(sql1);
//		Query deleteQuery = em.createNativeQuery(sql2);
//		
//		updateQuery.setParameter(1, 101);
//		deleteQuery.setParameter(1, 101);
//		
//		et.begin(); 
//		updateQuery.executeUpdate();
//		deleteQuery.executeUpdate();
//		et.commit();
//		
		
		Passport p = em.find(Passport.class, 101);
		System.out.println(p);
		System.out.println(p.getP());
		
		
	}

}
