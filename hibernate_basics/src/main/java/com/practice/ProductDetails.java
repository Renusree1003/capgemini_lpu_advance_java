package com.practice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProductDetails {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // INSERT
    public String insertProduct(Product product) {
        et.begin();
        em.persist(product);
        et.commit();
        //System.out.println("Product inserted");
		return "Product inserted";
    }

    // FIND
    public Product findProduct(int id) {
        Product product = em.find(Product.class, id);
        return product;
    }

    // UPDATE
    public void updateProduct(int id, double newPrice, int newQuantity) {
        et.begin();
        Product product = em.find(Product.class, id);

        if (product != null) {
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Product updated");
        } else {
            System.out.println("Product not found");
        }
        et.commit();
    }

    // DELETE
    public String deleteProduct(int id) {
        et.begin();
        Product product = findProduct(id);
        //Product product = em.find(Product.class, id);

        if (product != null) {
            em.remove(product);
            System.out.println("Product deleted");
            return "product deleted";
        } else {
            return "product not found";
        }
        //et.commit();
    }
    
    public void findAll() {
    	String jpql="Select p from Product p";
		Query query = em.createQuery(jpql);
		List<Product> list = query.getResultList();
		list.forEach(System.out::println);
    }

    // CLOSE RESOURCES
    public void close() {
        em.close();
        emf.close();
    }
}
