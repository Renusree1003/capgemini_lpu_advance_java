package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductDetailsTest {
	static EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeAll
	public static void initEmf() {
		System.out.println("Init emf");
		emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public void initEm() {
		em=emf.createEntityManager(); 
	}

	@Test
	public void insertProductTest() {
		ProductDetails details = new ProductDetails();
		Product product = new Product();
		product.setId(4);
		product.setName("pen");
		product.setPrice(10);
		product.setQuantity(5);

		String actualRes = details.insertProduct(product);
		assertEquals("Product inserted",actualRes);
	}
	
	@Test
	public void insertProductTestNull() {
		ProductDetails details = new ProductDetails();
		String actualRes = details.insertProduct(null);
		assertEquals("Illegal Argument",actualRes);
	}
	
	@Test
	public void findProductTest() {
		System.out.println("Product find");
		ProductDetails details = new ProductDetails();
		Product product = details.findProduct(2);
		assertNotNull(product);
	}
	
	@Test
	public void deleteProduct() {
		ProductDetails details = new ProductDetails();
		
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
