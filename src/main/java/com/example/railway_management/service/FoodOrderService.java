package com.example.railway_management.service;
import com.example.railway_management.model.FoodOrder;
import com.example.railway_management.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderService {

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    public void saveFoodOrder(FoodOrder foodOrder) {
        foodOrderRepository.saveFoodOrder(foodOrder);
    }
}
