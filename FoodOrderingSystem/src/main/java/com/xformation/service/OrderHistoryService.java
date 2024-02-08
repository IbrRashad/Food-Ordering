package com.xformation.service;

import com.xformation.enums.AdditionalRequest;
import com.xformation.model.OrderHistory;
import com.xformation.service.Inter.OrderHistoryInter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.time.LocalDateTime;

public class OrderHistoryService implements OrderHistoryInter {
    OrderHistoryInter orderHistoryServiceInter;

    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    @Override
    public void orderProduct(LocalDateTime orderHistory, String mainCourse, String dessert, String drinkName, AdditionalRequest additionalRequest) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        OrderHistory orderHistoryObj = OrderHistory.builder()
                .orderHistory(orderHistory)
                .drinkName(drinkName)
                .mainCourse(mainCourse)
                .dessert(dessert)
                .additionalRequest(additionalRequest)
                .build();

        session.save(orderHistoryObj);


        session.getTransaction().commit();

    }
    @Override
    public OrderHistory findOrderHistoryByDetails(String mainCourse, String dessert, String drinkName) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String hql = "FROM OrderHistory WHERE mainCourse = :mainCourse AND dessert = :dessert AND drinkName = :drinkName";
            Query query = session.createQuery(hql);
            query.setParameter("mainCourse", mainCourse);
            query.setParameter("dessert", dessert);
            query.setParameter("drinkName", drinkName);
            query.setMaxResults(1); // Set maximum results to 1
            return (OrderHistory) query.getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }}