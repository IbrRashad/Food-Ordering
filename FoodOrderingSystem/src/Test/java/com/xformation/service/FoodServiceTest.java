package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.model.Food;
import com.xformation.service.CountryService;
import com.xformation.service.FoodService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class FoodServiceTest {
    private FoodService foodService;
    private CountryService countryService;

    @BeforeEach
    public void setUp() {
        foodService = new FoodService();
        countryService = new CountryService();
    }

    @Test
    public void testAddProduct() {
        Country country = countryService.findCountryById(4); // Create a country or retrieve an existing one
        String mainCourse = "TestMainCourse";
        String dessert = "TestDessert";
        long price = 15;

        assertDoesNotThrow(() -> foodService.addProduct(mainCourse, dessert, price, country));

        Food addedFood = foodService.findFoodByMainCourseAndDessert(mainCourse, dessert);
        assertNotNull(addedFood);
        assertEquals(mainCourse, addedFood.getMainCourse());
        assertEquals(dessert, addedFood.getDessert());
        assertEquals(price, addedFood.getPrice());

    }

    @Test
    public void testGetAllFoods() {
        assertDoesNotThrow(() -> foodService.getAllFoods());
    }

    @Test
    public void testFindFoodById() {
        Country country = countryService.findCountryById(4); // Create a country or retrieve an existing one

        String mainCourse = "TestMainCourse";
        String dessert = "TestDessert";
        long price = 15;

        foodService.addProduct(mainCourse, dessert, price, country);
        Food addedFood = foodService.findFoodByMainCourseAndDessert(mainCourse, dessert);

        assertDoesNotThrow(() -> {
            Food foundFood = foodService.findFoodById(Math.toIntExact(addedFood.getId()));
            assertNotNull(foundFood);
            assertEquals(mainCourse, foundFood.getMainCourse());
            assertEquals(dessert, foundFood.getDessert());
            assertEquals(price, foundFood.getPrice());
        });

    }

    @Test
    public void testFindFoodByMainCourseAndDessert() {
        Country country = countryService.findCountryById(4); // Create a country or retrieve an existing one
        String mainCourse = "TestMainCourse";
        String dessert = "TestDessert";
        long price = 15;
        foodService.addProduct(mainCourse, dessert, price, country);

        // When
        assertDoesNotThrow(() -> {
            Food foundFood = foodService.findFoodByMainCourseAndDessert(mainCourse, dessert);

            // Then
            assertNotNull(foundFood);
            assertEquals(mainCourse, foundFood.getMainCourse());
            assertEquals(dessert, foundFood.getDessert());
            assertEquals(price, foundFood.getPrice());
        });
    }
}
