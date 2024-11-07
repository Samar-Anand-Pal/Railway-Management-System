package com.example.railway_management.service;

import com.example.railway_management.model.FoodService;
import com.example.railway_management.repository.FoodServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceService {

    private final FoodServiceRepository foodServiceRepository;

    public FoodServiceService(FoodServiceRepository foodServiceRepository) {
        this.foodServiceRepository = foodServiceRepository;
    }

    // Service method to get all food items
    public List<FoodService> getAllFoodItems() {
        return foodServiceRepository.getAllFoodItems();
    }
}
