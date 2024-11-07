package com.example.railway_management.controller;

import com.example.railway_management.model.FoodOrder;
import com.example.railway_management.model.Passenger;
import com.example.railway_management.model.Ticket;
import com.example.railway_management.repository.FoodOrderRepository;
import com.example.railway_management.repository.FoodServiceRepository;
import com.example.railway_management.repository.PassengerRepository;
import com.example.railway_management.service.PdfExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PdfExportController {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private FoodServiceRepository foodServiceRepository; // Repository to fetch food prices

    @GetMapping(value = "/ticket-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> passengerReport(
            @SessionAttribute("passengers") List<Passenger> passengers,
            @SessionAttribute("ticket") Ticket ticket,
            @SessionAttribute("distance") int distance) throws IOException {

        // Fetch food orders for the given ticketId
        List<FoodOrder> foodOrders = foodOrderRepository.findByTicketId(ticket.getTicketId());

        // List to hold food prices for each order
        List<Double> foodPrices = new ArrayList<>();

        // Calculate food prices for each food order
        for (FoodOrder foodOrder : foodOrders) {
            // Get the price of the food item from the FoodService table using foodName
            double foodPrice = foodServiceRepository.getFoodPriceByFoodName(foodOrder.getFoodName());
            // Calculate total price for the food order (foodPrice * quantity)
            double totalPrice = foodPrice ;
            foodPrices.add(totalPrice);  // Add the total price to the list
        }

        // Generate the PDF with passengers, food orders, and calculated food prices
        ByteArrayInputStream bis = PdfExportService.passengerPDFReport(passengers, ticket, distance, foodOrders, foodPrices);

        // Set PDF response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=passengers.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
