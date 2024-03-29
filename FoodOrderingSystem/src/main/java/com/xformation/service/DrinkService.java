package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.model.Drink;
import com.xformation.service.Inter.DrinkInter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DrinkService implements DrinkInter {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void addDrink(String name, long price, Country country) {
        session.beginTransaction();
        Drink drink = Drink.builder()
                .country(country)
                .name(name)
                .price(price)
                .build();
        country.getDrink().add(drink);
        session.save(drink);
        session.getTransaction().commit();
    }

    @Override
    public void getALlDrink() {
        session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country", Country.class).getResultList();
        for (Country country : countries) {
            List<Drink> drinks = country.getDrink();
            drinks.forEach(System.out::println);
        }
        session.getTransaction().commit();
    }

    @Override
    public Drink findDrinkById(int id) {
        session.beginTransaction();
        Drink drink = session.get(Drink.class, (long) id);
        session.getTransaction().commit();
        return drink;
    }
}
