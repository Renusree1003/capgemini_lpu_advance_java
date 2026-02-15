package com.assignment3_14thfeb;

import org.junit.jupiter.api.*;
import javax.persistence.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class EcommerceTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EcommerceService service;

    @BeforeAll
    static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        service = new EcommerceService(em);
    }

    @AfterEach
    void tearDown() {
        em.close();
    }

   
    @Test
    
    void oneToOnePersistTest() {

        Profile profile = new Profile();
        profile.setProfile_id(1);
        profile.setPhone("987654321");
        profile.setAddress("Bangalore");

        User user = new User();
        user.setUser_id(1);
        user.setName("Renu");
        user.setEmail("renu@gmail.com");

        service.registerUser(user, profile);

        User fetched = service.fetchUser(1);

        assertNotNull(fetched);
        assertEquals("987654321",
                fetched.getProfile().getPhone());
    }

   
    @Test
    
    void oneToManyPersistTest() {

        User user = service.fetchUser(1);

        PurchaseOrder o1 = new PurchaseOrder();
        o1.setPurchaseOrder_id(101);
        o1.setOrderDate("15-02-26");
        o1.setTotalAmount(5000);

        PurchaseOrder o2 = new PurchaseOrder();
        o2.setPurchaseOrder_id(102);
        o2.setOrderDate("16-02-26");
        o2.setTotalAmount(3000);

        service.addOrdersToUser(user,
                Arrays.asList(o1, o2));

        User updated = service.fetchUser(1);

        assertEquals(2,
                updated.getPurchaseOrders().size());
    }

   
    @Test
   
    void manyToOnePersistTest() {

        Payment payment = new Payment();
        payment.setPayment_id(500);
        payment.setMode("UPI");
        payment.setAmount(5000);

        service.addPaymentToOrder(101, payment);

        Payment saved =
                em.find(Payment.class, 500);

        assertNotNull(saved);
        assertEquals(5000,
                saved.getPurchaseOrder().getTotalAmount());
    }

  
    @Test
   
    void updateOrderAmountTest() {

        service.updateOrderAmount(101, 7000);

        PurchaseOrder updated =
                em.find(PurchaseOrder.class, 101);

        assertEquals(7000,
                updated.getTotalAmount());
    }

    @Test

    void deleteUserTest() {

        service.deleteUser(1);

        User deleted =
                em.find(User.class, 1);

        assertNull(deleted);
    }

 
    @Test
  
    void serviceIntegrationTest() {

        Profile profile = new Profile();
        profile.setProfile_id(10);
        profile.setPhone("123456789");
        profile.setAddress("Delhi");

        User user = new User();
        user.setUser_id(10);
        user.setName("Neha");
        user.setEmail("neha@gmail.com");

        service.registerUser(user, profile);

        PurchaseOrder order = new PurchaseOrder();
        order.setPurchaseOrder_id(200);
        order.setOrderDate("01-02-26");
        order.setTotalAmount(10000);

        service.addOrdersToUser(user,
                Arrays.asList(order));

        Payment payment = new Payment();
        payment.setPayment_id(900);
        payment.setMode("Card");
        payment.setAmount(10000);

        service.addPaymentToOrder(200, payment);

        User fetched = service.fetchUser(10);

        assertEquals(1,
                fetched.getPurchaseOrders().size());
    }
}
