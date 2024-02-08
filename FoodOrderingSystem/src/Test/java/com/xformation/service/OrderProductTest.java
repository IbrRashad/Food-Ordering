package com.xformation.service;

import com.xformation.enums.AdditionalRequest;
import com.xformation.model.OrderHistory;
import com.xformation.service.OrderHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class OrderProductTest {
    private OrderHistoryService orderHistoryService;

    @BeforeEach
    public void setUp() {
        orderHistoryService = new OrderHistoryService();
    }

    @Test
    public void testOrderProduct() {
        // Given
        LocalDateTime orderHistory = LocalDateTime.now();
        String mainCourse = "TestMainCourse";
        String dessert = "TestDessert";
        String drinkName = "TestDrink";
        AdditionalRequest additionalRequest = AdditionalRequest.ICE_CUBE; // Change as needed

        // When
        assertDoesNotThrow(() -> orderHistoryService.orderProduct(orderHistory, mainCourse, dessert, drinkName, additionalRequest));

        // Then
        // You may want to retrieve the added order history from the database and assert its properties
        // For example, find the order history by mainCourse, dessert, and drinkName, and then assert its properties
        OrderHistory addedOrderHistory = orderHistoryService.findOrderHistoryByDetails(mainCourse, dessert, drinkName);
        assertNotNull(addedOrderHistory);

        // Compare only the date part
        assertEquals(orderHistory.toLocalDate(), addedOrderHistory.getOrderHistory().toLocalDate());
        assertEquals(mainCourse, addedOrderHistory.getMainCourse());
        assertEquals(dessert, addedOrderHistory.getDessert());
        assertEquals(drinkName, addedOrderHistory.getDrinkName());
        assertEquals(additionalRequest, addedOrderHistory.getAdditionalRequest());


    }

    @Test
    public void testFindOrderHistoryByDetails() {
        // Test finding an order history by details
        // Add an order history, and then call the method to find the order history by details
        // Assert the expected result
        LocalDateTime orderHistory = LocalDateTime.now();
        String mainCourse = "TestMainCourse";
        String dessert = "TestDessert";
        String drinkName = "TestDrink";
        AdditionalRequest additionalRequest = AdditionalRequest.ICE_CUBE; // Change as needed

        orderHistoryService.orderProduct(orderHistory, mainCourse, dessert, drinkName, additionalRequest);

        assertDoesNotThrow(() -> {
            OrderHistory foundOrderHistory = orderHistoryService.findOrderHistoryByDetails(mainCourse, dessert, drinkName);
            assertNotNull(foundOrderHistory);

            // Compare only the date part
            assertEquals(orderHistory.toLocalDate(), foundOrderHistory.getOrderHistory().toLocalDate());
            assertEquals(mainCourse, foundOrderHistory.getMainCourse());
            assertEquals(dessert, foundOrderHistory.getDessert());
            assertEquals(drinkName, foundOrderHistory.getDrinkName());
            assertEquals(additionalRequest, foundOrderHistory.getAdditionalRequest());
        });

    }


}
