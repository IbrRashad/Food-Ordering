package com.xformation.service;

import com.xformation.enums.AdditionalRequest;
import com.xformation.model.OrderHistory;
import com.xformation.service.Inter.OrderHistoryInter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        session.close();

        sessionFactory.close();
    }


}
