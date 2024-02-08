package com.xformation.service.Inter;

import com.xformation.enums.AdditionalRequest;

import java.time.LocalDateTime;

public interface OrderHistoryInter {
    void orderProduct(LocalDateTime orderHistory, String mainCourse, String dessert,String drinkName, AdditionalRequest additionalRequest);
}
