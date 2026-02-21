package com.crm_21stfeb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderService {
	public static void placeOrder(Long customerId, List<Long> productIds, String orderDate) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, customerId);
		List<Product> products = new ArrayList<>();
		double total = 0;
		for(Long id : productIds) {
			Product p = em.find(Product.class, id);
			products.add(p);
			total += p.getPrice();
		}
		Order order = new Order();
		order.setOrderDate(orderDate);
		order.setCustomer(customer);
		order.setProduct(products);
		order.setTotalAmount(total);
		et.begin();
		em.persist(order);
		et.commit();
		
		System.out.println("Order placed");
	}

}
