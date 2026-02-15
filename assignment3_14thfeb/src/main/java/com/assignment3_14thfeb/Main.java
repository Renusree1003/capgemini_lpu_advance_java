package com.assignment3_14thfeb;

import javax.persistence.*;
import java.util.*;

public class Main{

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        EcommerceService service = new EcommerceService(em);

        

        Profile profile = new Profile();
        profile.setProfile_id(1);
        profile.setPhone("9999999999");
        profile.setAddress("Hyderabad");

        User user = new User();
        user.setUser_id(1);
        user.setName("Renu");
        user.setEmail("renu@gmail.com");

        service.registerUser(user, profile);

        

       //to add order

        PurchaseOrder order1 = new PurchaseOrder();
        order1.setPurchaseOrder_id(101);
        order1.setOrderDate("02-02-26");
        order1.setTotalAmount(5000);

        PurchaseOrder order2 = new PurchaseOrder();
        order2.setPurchaseOrder_id(102);
        order2.setOrderDate("03-02-26");
        order2.setTotalAmount(3000);

        service.addOrdersToUser(user,
                Arrays.asList(order1, order2));

        System.out.println("Orders Added Successfully");

        
        //to update orders
        Payment payment = new Payment();
        payment.setPayment_id(500);
        payment.setMode("UPI");
        payment.setAmount(5000);

        service.addPaymentToOrder(101, payment);

       

        service.updateOrderAmount(101, 7000);
        System.out.println("Order Updated Successfully");

       //to fetch order

        User fetchedUser = service.fetchUser(1);

       
        System.out.println(fetchedUser.getName());
        System.out.println(fetchedUser.getEmail());
        System.out.println(fetchedUser.getPurchaseOrders().size());

        
        //to delete user
        service.deleteUser(1);
        System.out.println("User Deleted Successfully");

        em.close();
        emf.close();
    }
}
