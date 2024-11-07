package com.example.railway_management.controller;

import com.example.railway_management.model.Ticket;
import com.example.railway_management.model.Train;
// import com.example.railway_management.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;  
import com.example.railway_management.model.Users;
import com.example.railway_management.service.TicketService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MyBookingController {

     @Autowired
    private TicketService ticketService;

    @GetMapping("/mybooking")
    public String myBooking(Model model) {
        // Add necessary attributes to the model if needed
        // For example, if you want to show a list of bookings:
        // model.addAttribute("bookings", bookingService.getUserBookings());
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=principal.getUsername();
         List<Ticket> tickets = ticketService.getTicketsByUsername(username);
        model.addAttribute("tickets", tickets);

        return "mybooking"; // Returns the "mybooking" view (e.g., mybooking.html)
    }
}
