package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.model.Drink;
import com.xformation.service.CountryService;
import com.xformation.service.DrinkService;
import com.xformation.service.Inter.CountryInter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkServiceTest {

    private CountryService countryService;
    private DrinkService drinkService;

    @BeforeEach
    public void setUp() {
        drinkService = new DrinkService();
        countryService = new CountryService();
    }

    @Test
    public void testAddDrink() {
        Country country = countryService.findCountryById(4);
        String drinkName = "TestDrink";
        long price = 10;

        assertDoesNotThrow(() -> drinkService.addDrink(drinkName, price, country));

        Drink addedDrink = drinkService.findDrinkByName(drinkName);
        assertNotNull(addedDrink);
        assertEquals(drinkName, addedDrink.getName());
        assertEquals(price, addedDrink.getPrice());

    }
    @Test
    public void testGetAllDrink() {
        assertDoesNotThrow(() -> drinkService.getALlDrink());
    }
    @Test
    public void testFindDrinkById() {
        Country country = countryService.findCountryById(4);
                String drinkName = "TestDrink";
        long price = 10;

        drinkService.addDrink(drinkName, price, country);
        Drink addedDrink = drinkService.findDrinkByName(drinkName);
        assertDoesNotThrow(() -> {
            Drink foundDrink = drinkService.findDrinkById(Math.toIntExact(addedDrink.getId()));
            assertNotNull(foundDrink);
            assertEquals(drinkName, foundDrink.getName());
            assertEquals(price, foundDrink.getPrice());
        });
    }
}
