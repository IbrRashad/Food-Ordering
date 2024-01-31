package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.service.Inter.CountryInter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CountryService implements CountryInter {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    @Override
    public void addCountry(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Country country = Country.builder()
                .name(name)
                .build();

        session.save(country);

        session.getTransaction().commit();
        session.close();

        sessionFactory.close();
    }
}
