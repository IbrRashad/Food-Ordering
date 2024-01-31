package com.xformation;

import com.xformation.enums.AdditionalRequest;
import com.xformation.model.Drink;
import com.xformation.model.Food;
import com.xformation.model.OrderHistory;
import com.xformation.service.DrinkService;
import com.xformation.service.FoodService;
import com.xformation.service.OrderHistoryService;
import com.xformation.utility.InputUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        FoodService foodService = new FoodService();
        DrinkService drinkService = new DrinkService();
        OrderHistoryService orderHistory = new OrderHistoryService();
        LocalDateTime localDateTime = LocalDateTime.now();

            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            System.out.println("1. List Food\n2. List Drink");
            int result = InputUtil.getIntegerInput("Choose:");

            if (result == 1) {
                foodService.getAllFoods();
                int orderId = InputUtil.getIntegerInput("Select food you want to buy:");
                Food orderedFood = foodService.findFoodById(orderId);
                orderHistory.orderProduct(localDateTime, orderedFood.getDessert(), orderedFood.getMainCourse(), null, null);
            } else if (result == 2) {

                drinkService.getALlDrink();
                int orderId = InputUtil.getIntegerInput("Select drink you want to buy:");
                Drink orderedDrink = drinkService.findDrinkById(orderId);
                int addRequest = InputUtil.getIntegerInput("1.ice cube\n2.lemon");
                AdditionalRequest additionalRequest = (addRequest == 1) ? AdditionalRequest.ICE_CUBE : AdditionalRequest.LEMON;
                orderHistory.orderProduct(localDateTime, null, null, orderedDrink.getName(), additionalRequest);
            }
            session.close();
            sessionFactory.close();

        // Close the session and sessionFactory outside the if block
    }
}