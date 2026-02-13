package onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	public static void main(String[] args) {
		//findByCarId();
		deleteByEngineId();

	}
	public static void findByCarId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Car c = em.find(Car.class, 1);
		System.out.println(c);
		System.out.println(c.getEngine().getCc());

		
	}
	
	public static void deleteByEngineId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		//Car c = em.find(Car.class, 1);
		//Engine e = em.find(Engine.class, 100);
		
		//em.remove(e);
		
		Query updateQuery = em.createNativeQuery("Update car set engine_id=null where engine_id=?1");
		updateQuery.setParameter(1, 100);
		Query deleteQuery = em.createNativeQuery("Delete from engine where id=?1");
		deleteQuery.setParameter(1, 100);
		et.begin();
		updateQuery.executeUpdate();
		deleteQuery.executeUpdate();
		et.commit();
		
		
		
	}

	public static void insertCarAndEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Engine e = new Engine();
		e.setId(100);
		e.setType("V8");
		e.setFuelType("Petrol");
		e.setMileage("12");
		e.setCc("3000");

		Car c = new Car();
		c.setId(1);
		c.setBrand("Volkswagen");
		c.setModel("Polo GT10");
		c.setModelYear("2019");
		c.setPrice(100000);
		c.setEngine(e);

		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();

	}

}
