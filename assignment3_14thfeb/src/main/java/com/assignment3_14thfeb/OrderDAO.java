package com.assignment3_14thfeb;

import javax.persistence.*;
import java.util.*;

public class OrderDAO {

    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void saveOrder(PurchaseOrder order) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(order);
        et.commit();
    }

    public PurchaseOrder findOrder(int id) {
        return em.find(PurchaseOrder.class, id);
    }

    public List<PurchaseOrder> findOrdersByUser(int userId) {
        User user = em.find(User.class, userId);
        return user.getPurchaseOrders();
    }
}
