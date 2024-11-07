package com.example.railway_management.controller;

import com.example.railway_management.model.TrainSchedule;
import com.example.railway_management.service.TrainEnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class TrainEnquiryController {

    private final TrainEnquiryService trainEnquiryService;

    @Autowired
    public TrainEnquiryController(TrainEnquiryService trainEnquiryService) {
        this.trainEnquiryService = trainEnquiryService;
    }

    // Method to show the train enquiry form
    @GetMapping("/train-enquiry")
    public String showTrainEnquiryForm() {
        return "train_enquiry";  // This will render train_enquiry.html
    }

    // Method to handle form submission
    @PostMapping("/train-enquiry")
    public String handleTrainEnquiry(@RequestParam("trainId") int trainId, Model model) {
        List<TrainSchedule> trainSchedule = trainEnquiryService.getTrainScheduleById(trainId);
        if (trainSchedule != null) {
            model.addAttribute("trainSchedule", trainSchedule);  // Pass the schedule details to the model
            model.addAttribute("tId",trainId);
            return "train_enquiry_result";  // Render a result page after processing
        } else {
            model.addAttribute("errorMessage", "Train not found");
            return "train_enquiry";  // Re-render the form with an error message
        }
    }
}
