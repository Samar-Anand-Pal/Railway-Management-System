package com.example.railway_management.controller;

import com.example.railway_management.model.FoodOrder;
import com.example.railway_management.model.Passenger;
import com.example.railway_management.model.SeatInfo;
import com.example.railway_management.model.Ticket;
import com.example.railway_management.service.TicketService;
import com.example.railway_management.service.BookingService;
import com.example.railway_management.service.FoodOrderService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.ui.Model;

@Controller
public class PaymentController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FoodOrderService foodOrderService; // Inject the FoodOrderService

    @PostMapping("/Payment")
    public String processPayment(@SessionAttribute("passengers") List<Passenger> passengers,
                                 @SessionAttribute("ticket") Ticket ticket,
                                 @SessionAttribute("totalPayableAmount") int totalPayableAmount,
                                 @SessionAttribute("payableAmount") int payableAmount,
                                 @SessionAttribute("foodprice") int foodprice, 
                                 @SessionAttribute("foodName") List<String> foodName,
                                 @SessionAttribute("quantity") List<Integer> quantities,
                                 @RequestParam("amount") int amount,
                                 Model model) {
        // Check if the amount matches the total payable amount
        if (totalPayableAmount == amount) {
            // Payment is successful
            System.out.println("Payment successful!");

            // Save the ticket details
            ticketService.saveTicket(ticket);

            // Save the food orders
            saveFoodOrders(ticket, foodName, quantities);

            // Get available seats for the booking
            LocalDate dateOfJourney = ticket.getDateOfJourney();
            String dayOfWeek = dateOfJourney.getDayOfWeek().toString().toLowerCase(); // Convert to lower case to match DB entries
            List<SeatInfo> seatInfoList = bookingService.getAvailableSeats(
                ticket.getTrainId(),
                dayOfWeek,
                ticket.getTrainId(),
                ticket.getTicketClass()
            );

            if (seatInfoList.isEmpty()) {
                model.addAttribute("errorMessage", "No available seats found for your journey.");
                return "Payment"; // Return to payment page with error message
            }

            // Assign seats to passengers
            for (int i = 0; i < passengers.size(); i++) {
                if (i < seatInfoList.size()) { // Check if there are enough available seats
                    SeatInfo seatInfo = seatInfoList.get(i);
                    Passenger passenger = passengers.get(i);
                    passenger.setTicketId(ticket.getTicketId());
                    passenger.setSeatNo(seatInfo.getSeatNo()); // Set seat number
                    passenger.setCoachNo(seatInfo.getCoachNo()); // Set coach number

                    // Update seat status in the database
                    bookingService.updateSeatStatus(ticket.getTrainId(), seatInfo.getCoachNo(), dayOfWeek, seatInfo.getSeatNo());
                    System.out.println("Assigned Seat No: " + seatInfo.getSeatNo() + ", Coach No: " + seatInfo.getCoachNo() + " to Passenger: " + passenger.getFirstName());
                } else {
                    System.out.println("Not enough available seats for all passengers.");
                    break; // Exit if there are not enough seats
                }
            }

            ticketService.savePassengers(passengers); // Save passengers in the database
            model.addAttribute("message", "Payment of amount " + amount + " was successful!");
            return "download_ticket"; // Redirect to a confirmation page

        } else {
            // Payment failed, set an error message
            model.addAttribute("foodprice", foodprice);
            model.addAttribute("totalPayableAmount", totalPayableAmount);
            model.addAttribute("errorMessage", "Payment unsuccessful. Please re-enter the correct amount.");
            model.addAttribute("payableAmount", payableAmount);
            return "Payment"; // Return to the payment page for re-entry
        }
    }

    private void saveFoodOrders(Ticket ticket, List<String> foodNames, List<Integer> quantities) {
        // Save the food orders in the database using JDBC
        for (int i = 0; i < foodNames.size(); i++) {
            String foodName = foodNames.get(i);
            int quantity = quantities.get(i);

            if (quantity > 0) { // Only save if quantity is greater than 0
                FoodOrder foodOrder = new FoodOrder();
                foodOrder.setTicketId(ticket.getTicketId()); // Link to the ticket
                foodOrder.setFoodName(foodName); // Set the food item name
                foodOrder.setQuantity(quantity); // Set the quantity of the food item

                // Save the food order using the FoodOrderService (which uses JDBC)
                foodOrderService.saveFoodOrder(foodOrder);
                System.out.println("Food Order: " + foodName + ", Quantity: " + quantity + " for Ticket ID: " + ticket.getTicketId());
            }
        }
    }
}
