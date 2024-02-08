package com.xformation.service;

import com.xformation.model.Country;
import com.xformation.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CountryServiceTest {
    private CountryService countryService;


    @BeforeEach
    public void setUp() {
        countryService = new CountryService();
    }

    @Test
    public void testAddCountry() {
        // Given
        String countryName = "TestCountry";

        // When
        assertDoesNotThrow(() -> countryService.addCountry(countryName));

        // Then
        // You may want to retrieve the added country from the database and assert its properties
        // For example, using a method to find the country by name and then asserting its properties
        Country addedCountry = countryService.findCountryByName(countryName);
        assertNotNull(addedCountry);
        assertEquals(countryName, addedCountry.getName());

        // Clean up: Delete the added country or reset the database state
        // Depending on your testing strategy, you may want to clean up the added data
    }
}
