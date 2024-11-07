// package com.example.railway_management.controller;

// import com.example.railway_management.model.FoodService;
// import com.example.railway_management.service.FoodService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;  
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import java.util.List;

// @Controller
// public class FoodController {

//     @Autowired
//     private FoodService foodService;

//     @GetMapping("/food-order")
//     public String getFoodOrderPage(Model model) {
//         List<FoodService> foodItems = foodService.getAllFoodItems();
//         model.addAttribute("foodItems", foodItems);
//         return "ticketConfirmation";  // This maps to ticketConfirmation.html
//     }

//     @PostMapping("/orderFood")
//     public String orderFood(
//             @RequestParam String foodItem,
//             @RequestParam int quantity,
//             @RequestParam int ticketId, 
//             Model model) {
        
//         foodService.orderFood(ticketId, foodItem, quantity);
        
//         List<FoodService> foodItems = foodService.getAllFoodItems();
//         model.addAttribute("foodItems", foodItems);
//         model.addAttribute("message", "Food ordered successfully!");
        
//         return "ticketConfirmation"; // Redirect back to the ticket confirmation page
//     }
// }
