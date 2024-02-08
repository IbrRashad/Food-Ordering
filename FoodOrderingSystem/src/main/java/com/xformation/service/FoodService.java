package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.model.Food;
import com.xformation.service.Inter.FoodInter;
import com.xformation.utility.InputUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FoodService implements FoodInter {
    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    Session session = sessionFactory.openSession();

    @Override
    public void addProduct(String mainCourse,String dessert, long price, Country country) {
        session.beginTransaction();

        Food food = Food.builder()
                .mainCourse(mainCourse)
                .dessert(dessert)
                .price(price)
                .country(country)
                .build();
        country.getFoods().add(food);

        session.save(food);

        session.getTransaction().commit();

    }

    @Override
    public void getAllFoods() {
        session.beginTransaction();
        List<Country> countries = session.createQuery("FROM Country", Country.class).getResultList();
        for (Country country : countries) {
            List<Food> foods = country.getFoods();
            foods.forEach(System.out::println);
        }
        session.getTransaction().commit();
    }

    @Override
    public Food findFoodById(int id) {
        session.beginTransaction();
        Food food = session.get(Food.class, (long) id);

        session.getTransaction().commit();
        return food;
    }
}
