package com.xformation.service.Inter;

import com.xformation.enums.AdditionalRequest;
import com.xformation.model.OrderHistory;

import java.time.LocalDateTime;

public interface OrderHistoryInter {
    void orderProduct(LocalDateTime orderHistory, String mainCourse, String dessert, String drinkName, AdditionalRequest additionalRequest);

    OrderHistory findOrderHistoryByDetails(String mainCourse, String dessert, String drinkName);
}
