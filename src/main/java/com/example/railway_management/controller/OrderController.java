package com.example.railway_management.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.railway_management.model.FoodOrderPair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.railway_management.model.Passenger;
import com.example.railway_management.model.Ticket;
import com.example.railway_management.model.FoodService;
import com.example.railway_management.model.Train;
import com.example.railway_management.model.TrainSchedule;
import com.example.railway_management.service.TicketService;
import com.example.railway_management.service.FoodServiceService;
import com.example.railway_management.service.TrainService;
import com.example.railway_management.service.TrainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SessionAttributes({"payableAmount", "passengers", "ticket", "foodName", "quantity" , "totalPayableAmount" , "foodprice"})


@Controller
public class OrderController {





    
    @PostMapping("/submitOrder")


    public String initiatePayment(@SessionAttribute("payableAmount") int payableAmount,
                                   @RequestParam("totalPrice") double totalPrice, 
                                   @RequestParam List<String> foodName,
                                    @RequestParam List<Integer> quantity,
                                   Model model) {
        int foodprice = (int) totalPrice; // Convert to int if needed (e.g., rounding down)


        model.addAttribute("foodName",foodName);
        model.addAttribute("quantity",quantity);
        
        int totalPayableAmount = payableAmount + foodprice;
        model.addAttribute("payableAmount", payableAmount);
        model.addAttribute("foodprice", foodprice);
        model.addAttribute("totalPayableAmount", totalPayableAmount);
        model.addAttribute("message", "Proceed with Payment");

        return "Payment"; // Ensure a corresponding payment.html file exists in the templates
    }

    // @PostMapping("/submitOrder")
    // public String submitOrder(@RequestParam List<String> foodName,
    //                           @RequestParam List<Integer> quantity,
    //                           @RequestParam double totalPrice,
    //                           Model model) {
    //     // Handle order submission
    //     for (int i = 0; i < foodName.size(); i++) {
    //         // Process each food item ordered
    //         System.out.println("Ordered: " + foodName.get(i) + ", Quantity: " + quantity.get(i));
    //     }
    //     System.out.println("Total Price: ₹" + totalPrice);

    //     // Pass the total price or any other data to the confirmation page
    //     model.addAttribute("totalPrice", totalPrice);
    //     return "payment";  // Redirect to an order confirmation page
    // }
}
