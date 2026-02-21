package com.crm_21stfeb;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TicketService {
	public static void raiseTicket(Long orderId, String issue, String status) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Order order = em.find(Order.class, orderId);
		SupportTicket ticket = new SupportTicket();
		ticket.setOrder(order);
		ticket.setIssue("damaged");
		ticket.setStatus("received");
		et.begin();
		em.persist(ticket);
		et.commit();
		
		System.out.println("Ticket raised");
		
	}

}
