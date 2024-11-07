package com.example.railway_management.controller;

import com.example.railway_management.model.Train;
import com.example.railway_management.service.BookingService;
import com.example.railway_management.service.TrainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.railway_management.model.Quad;
import com.example.railway_management.model.TrainSchedule;
 // Import the shared Quad class

//... (rest of the code remains unchanged)

import java.util.List;


@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book-ticket")
    public String bookTicket() {
        System.out.println("Received GET request to /book-ticket");
        return "book-ticket";  // This maps to book-ticket.html
    }

    @PostMapping("/book-ticket")
    public String bookTicket(
            @RequestParam int from,
            @RequestParam int to,
            @RequestParam String date,
            @RequestParam String trainClass,
            Model model) {
    
        System.out.println("Received POST request to /book-ticket");
        System.out.println("Parameters: from=" + from + ", to=" + to + ", date=" + date + ", class=" + trainClass);
    
        // Fetch available trains based on the from, to stations, and date
        List<Quad> tr = bookingService.searchTrains1(from, to, date);
    
        // Add the trains list to the model to be used in the view
        model.addAttribute("train11", tr); // Ensure this variable name matches in your HTML
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("date", date);
    
        // Return the view name for the results page
        return "train-results"; // Make sure this matches the HTML template file name
    }
    
}
