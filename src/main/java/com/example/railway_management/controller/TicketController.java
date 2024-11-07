// package com.example.railway_management.controller;

// import com.example.railway_management.model.Passenger;
// import com.example.railway_management.model.Ticket;
// import com.example.railway_management.model.Train;
// import com.example.railway_management.service.TicketService;
// import com.example.railway_management.service.TrainService;
// import com.example.railway_management.service.TrainScheduleService;
// import com.example.railway_management.model.TrainSchedule;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;  
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.SessionAttributes;
// import java.util.*;
// import java.util.Random;
// import java.time.LocalDate;
// import java.time.LocalTime;
// import java.util.ArrayList;
// import java.util.List;

// @Controller 
// @SessionAttributes({"passengers","ticket","distance" , "payableAmount" })

// public class TicketController {

//     @Autowired
//     private TicketService ticketService; // Service to fetch train details
//     @Autowired
//     private TrainScheduleService trainScheduleService;
//     @Autowired
//     private TrainService trainService;
    
//     // Display the ticket booking form
//     @GetMapping("/Ticket-form")
//     public String showTicketForm(
//         @RequestParam("trainId") int trainId, 
//         @RequestParam("class") String travelClass,
//         @RequestParam("from") String from,
//         @RequestParam("to") String to,
//         @RequestParam("date") String date,
//         Model model) {
        
//         System.out.println("get ticket-form");
//         Train train = ticketService.findById1(trainId); // Fetch train by ID

//         // Add prefilled values to the model
//         model.addAttribute("trainId", trainId);
//         model.addAttribute("trainName", train.getTrainName());
//         model.addAttribute("class", travelClass);
//         model.addAttribute("from", from);
//         model.addAttribute("to", to);
//         model.addAttribute("date", date);
//         model.addAttribute("username", "chetan"); // Replace with actual username from session/authentication
//         System.out.println("get ticket-form done");
//         return "ticket"; // Render ticket.html
//     }

//     @PostMapping("/Ticket-form")
//     public String bookTicket(
//         @RequestParam("trainId") int trainId,
//         @RequestParam("class") String travelClass,
//         @RequestParam("username") String username,
//         @RequestParam("passengerName") String[] passengerNames,
//         @RequestParam("age") int[] ages,
//         @RequestParam("gender") String[] genders,
//         @RequestParam("from") String from,
//         @RequestParam("to") String to,
//         @RequestParam("date") String date, // Keep this as String
//         Model model) {

//          int distance=0,payableAmount=0;
//         List<Passenger> passengers = new ArrayList<>();

//         // Get train schedule based on station and train ID
//         List<TrainSchedule> trainSchedules = trainScheduleService.getScheduleByStationAndTrainId(from, trainId);
//         // Assuming you want the first schedule if there are multiple
//         TrainSchedule t1 = trainSchedules.isEmpty() ? null : trainSchedules.get(0);

//         // if (t1 == null) {
//         //     model.addAttribute("message", "No train schedule found.");
//         //     return "error";
//         // }
     
//         System.out.println("Adding passenger started:");
//         try {
//             // Randomized placeholders
//             Random random = new Random();
//             String[] stations = {"StationA", "StationB", "StationC", "StationD"};
//             String[] travelClasses = {"First", "Second", "Sleeper", "AC"};
//             String randomBookingStation = stations[random.nextInt(stations.length)];
//             String randomDestinationStation = stations[random.nextInt(stations.length)];
//             LocalDate randomDateOfJourney = LocalDate.now().plusDays(random.nextInt(30)); // Random date within 30 days
//             LocalDate randomBookingDate = LocalDate.now();
//             LocalTime randomArrivalTime = LocalTime.of(random.nextInt(24), random.nextInt(60), random.nextInt(60));
//             String randomTravelClass = travelClasses[random.nextInt(travelClasses.length)];

//             // Create and populate the Ticket object with random values
//             Ticket ticket = new Ticket();
//             ticket.setBookingStation(from);
//             ticket.setDestinationStation(to);
//             ticket.setDateOfJourney(randomDateOfJourney); // Corrected to use LocalDate
//             ticket.setBookingDate(randomBookingDate);
//             ticket.setArrivalTime(t1.getArrivalTime()); // Use getter
//             ticket.setTicketClass(travelClass);

//             // Set other random fields for testing
//             ticket.setPnrNo("PNR" + random.nextInt(1000000)); // Random PNR
//             ticket.setTicketStatus("Confirmed");
//             ticket.setTrainStatus("Scheduled");
//             ticket.setRouteId(1);
//             ticket.setPrice(100 + (900 * random.nextDouble()));

//             // ticketService.saveTicket(ticket);

//             // Proceed to save passengers
//             for (int i = 0; i < passengerNames.length; i++) {
//                 Passenger passenger = new Passenger();
//                 passenger.setFirstName(passengerNames[i]);
//                 int currentYear = LocalDate.now().getYear();
//                 int birthYear = currentYear - ages[i];
//                 passenger.setDateOfBirth(LocalDate.of(birthYear, 1, 1));
//                 passenger.setGender(genders[i]);
//                 passenger.setUserName(username);
//                 passenger.setTrainId(trainId.intValue());
//                 passenger.setTicketId(ticket.getTicketId());

//                 passengers.add(passenger);
//                 System.out.println("Added passenger: " + passengerNames[i]);
//             }
//             System.out.println("tickedId "+ticket.getTicketId());
//             // ticketService.savePassengers(passengers);

//             //Calculating the price
//             // Date d=trainScheduleService.giveArrivalTime();
           
//             int tId = trainId.intValue();
//             double timeDifferenceInHours = trainScheduleService.getTimeDifferenceInFractionalHours(tId, from, to, date);
//             System.out.println("dekho "+trainScheduleService.getTimeDifferenceInFractionalHours(tId, from, to, date));
            
//             String type= trainService.getTrainType(tId);
            
//             if(type=="EXPRESS"){
//                 //Normal Express
//                 distance=(int)Math.ceil(60*timeDifferenceInHours);
//             }
//             else if(type=="SUPERFAST")  distance=(int)Math.ceil(80*timeDifferenceInHours);
//             else  distance=(int)Math.ceil(40*timeDifferenceInHours);
            
//             if(travelClass=="General") payableAmount=passengers.size()*(int)Math.ceil(0.5*distance);
//             else if(travelClass=="SLEEPER")  payableAmount=passengers.size()*distance;
//             payableAmount=passengers.size()*2*distance;
//             System.out.println("PayableAmount " + payableAmount);
            
//             model.addAttribute("message", "Tickets successfully booked!");
//             model.addAttribute("ticket", ticket);
//             model.addAttribute("passengers", passengers);
//             model.addAttribute("distance",distance);
//             model.addAttribute("payableAmount",payableAmount);
            

//             return "Confirmation";

//         } catch (Exception e) {
//             e.printStackTrace();
//             model.addAttribute("message", "Error booking tickets: " + e.getMessage());
//             return "book-ticket";
//         }
//     }
// }


package com.example.railway_management.controller;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import com.example.railway_management.model.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SessionAttributes({"passengers", "ticket", "distance", "payableAmount"})
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private TrainScheduleService trainScheduleService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private FoodServiceService foodServiceService;

    @GetMapping("/Ticket-form")
    public String showTicketForm(
            @RequestParam("trainId") int trainId,
            @RequestParam("class") String travelClass,
            @RequestParam("from") int from,
            @RequestParam("to") int to,
            @RequestParam("date") String date,
            @RequestParam("maxSeats") int maxSeats,
            
            Model model) {
        System.out.println("maxSeats\n"+maxSeats);
        Train train = ticketService.findById1(trainId);
        model.addAttribute("trainId", trainId);
        model.addAttribute("trainName", train.getTrainName());
        model.addAttribute("class", travelClass);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("date", date);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=principal.getUsername();

        model.addAttribute("username", username);
        model.addAttribute("maxSeats",maxSeats);
        return "ticket";
    }

    @PostMapping("/Ticket-form")
    public String bookTicket(
            @RequestParam("trainId") int trainId,
            @RequestParam("class") String travelClass,
        
            @RequestParam("passengerName") String[] passengerNames,
            @RequestParam("age") int[] ages,
            @RequestParam("gender") String[] genders,
            @RequestParam("from") int from,
            @RequestParam("to") int to,
            @RequestParam("date") String date,
            // @SessionAttribute("username") String username,
            Model model) {
        
         User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=principal.getUsername();

        int distance = 0, payableAmount = 0;
        List<Passenger> passengers = new ArrayList<>();
        System.out.println(("train id "+trainId));
        List<TrainSchedule> trainSchedules = trainScheduleService.getScheduleByStationAndTrainId(from, trainId);
        TrainSchedule t1 = trainSchedules.isEmpty() ? null : trainSchedules.get(0);

        try {
            Random random = new Random();

            Ticket ticket = new Ticket();
            ticket.setBoardingStation(from);
            ticket.setDestinationStation(to);
            ticket.setDateOfJourney(LocalDate.parse(date));
            ticket.setBookingDate(LocalDate.now());
            ticket.setTicketClass(travelClass);
            ticket.setTrainId(trainId);
            ticket.setTicketId(random.nextInt(1000000));
            ticket.setUsername(username);

            for (int i = 0; i < passengerNames.length; i++) {
                Passenger passenger = new Passenger();
                passenger.setFirstName(passengerNames[i]);
                passenger.setAge(ages[i]);
                passenger.setGender(genders[i]);
                passenger.setTicketId(ticket.getTicketId());
                
                // passenger.setCoachNo(random.nextInt(10) + 1);  // Example coach assignment
                // passenger.setSeatNo(random.nextInt(50) + 1);   // Example seat assignment
                passengers.add(passenger);
            }
          
            double timeDifferenceInHours = trainScheduleService.getTimeDifferenceInFractionalHours(trainId, from, to, date);
            String type = trainService.getTrainType(trainId);

            if ("EXPRESS".equals(type)) {
                distance = (int) Math.ceil(60 * timeDifferenceInHours);
            } else if ("SUPERFAST".equals(type)) {
                distance = (int) Math.ceil(80 * timeDifferenceInHours);
            } else {
                distance = (int) Math.ceil(40 * timeDifferenceInHours);
            }

            if ("General".equalsIgnoreCase(travelClass)) {
                payableAmount = passengers.size() * (int) Math.ceil(0.5 * distance);
            } else if ("SLEEPER".equalsIgnoreCase(travelClass)) {
                payableAmount = passengers.size() * distance;
            } else {
                payableAmount = passengers.size() * 2 * distance;
            }

            model.addAttribute("message", "Tickets successfully booked!");
            model.addAttribute("ticket", ticket);
            model.addAttribute("passengers", passengers);
            model.addAttribute("distance", distance);
            model.addAttribute("payableAmount", payableAmount);


            List<FoodService> fs = foodServiceService.getAllFoodItems();
            model.addAttribute("fs",fs);
    
            for( FoodService food:fs)
            System.out.println("foodname is" + food.getFoodName());
    

            return "Confirmation";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Error booking tickets: " + e.getMessage());
            return "book-ticket";
        }
    }
}
