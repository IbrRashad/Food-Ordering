package com.xformation.service.Inter;

import com.xformation.model.Country;
import com.xformation.model.Drink;

public interface DrinkInter {
    void addDrink(String name, long price, Country country);

    void getALlDrink();

    Drink findDrinkById(int id);
}
