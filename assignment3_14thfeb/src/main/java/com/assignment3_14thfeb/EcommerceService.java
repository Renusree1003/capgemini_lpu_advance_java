package com.assignment3_14thfeb;

import javax.persistence.*;
import java.util.*;

public class EcommerceService {

    private UserDAO userDAO;
    private OrderDAO orderDAO;
    private PaymentDAO paymentDAO;
    private EntityManager em;

    public EcommerceService(EntityManager em) {
        this.em = em;
        this.userDAO = new UserDAO(em);
        this.orderDAO = new OrderDAO(em);
        this.paymentDAO = new PaymentDAO(em);
    }

    //  Register User with Profile
    public void registerUser(User user, Profile profile) {

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(profile);
        user.setProfile(profile);
        et.commit();

        userDAO.saveUser(user);
    }

    //  Add Multiple Orders
    public void addOrdersToUser(User user, List<PurchaseOrder> orders) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        for (PurchaseOrder o : orders) {
            em.persist(o);
        }

        user.setPurchaseOrders(orders);

        et.commit();

        userDAO.updateUser(user);
    }

    //  Add Payment to Order
    public void addPaymentToOrder(int orderId, Payment payment) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        PurchaseOrder order = em.find(PurchaseOrder.class, orderId);
        payment.setPurchaseOrder(order);

        em.persist(payment);

        et.commit();
    }

    //  Update Order Amount
    public void updateOrderAmount(int orderId, double amount) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        PurchaseOrder order = em.find(PurchaseOrder.class, orderId);
        order.setTotalAmount(amount);

        et.commit();
    }

    //  Fetch User
    public User fetchUser(int userId) {
        return userDAO.findUser(userId);
    }

    // Delete User
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
