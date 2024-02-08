package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.model.Drink;
import com.xformation.service.Inter.CountryInter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.Query;

public class CountryService implements CountryInter {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    Session session = sessionFactory.openSession();

    @Override
    public void addCountry(String name) {
        session.beginTransaction();

        Country country = Country.builder()
                .name(name)
                .build();

        session.save(country);

        session.getTransaction().commit();

    }

    @Override
    public Country findCountryByName(String name) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String hql = "FROM Country WHERE name = :countryName";
            Query query = session.createQuery(hql);
            query.setParameter("countryName", name);
            query.setMaxResults(1); // Set maximum results to 1
            return (Country) query.getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Country findCountryById(int id) {
        session.beginTransaction();
        Country country = session.get(Country.class, (long) id);
        session.getTransaction().commit();
        return country;
    }
}
