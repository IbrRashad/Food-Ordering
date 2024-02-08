package com.xformation.service.Inter;

import com.xformation.model.Country;
import com.xformation.model.Food;

public interface FoodInter {

    void addProduct(String mainCourse,String dessert, long price, Country country);
    void getAllFoods();
    Food findFoodById(int id);
    Food findFoodByMainCourseAndDessert(String mainCourse, String dessert);
}
