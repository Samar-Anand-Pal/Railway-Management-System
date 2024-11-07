package com.example.railway_management.service;

import com.example.railway_management.model.Train;
import com.example.railway_management.model.TrainSchedule;
import com.example.railway_management.repository.TrainRepository;
import com.example.railway_management.repository.TrainScheduleRepository;
import com.example.railway_management.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.railway_management.model.Quad; // Import the shared Quad class
import com.example.railway_management.model.SeatInfo;
import java.time.DayOfWeek;

//... (rest of the code remains unchanged)

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {


    @Autowired
    private TrainRepository trainRepository;


    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private CheckRepository checkRepository;

    // public List<Train> searchTrains(String from, String to, String date) {
    //     // Convert date to day of the week
    //     String dayOfWeek = convertDateToDayOfWeek(date);
        
    //     // Fetch available trains based on the from, to stations, and dayOfWeek
    //     List<TrainSchedule> schedules = trainScheduleRepository.findByFromAndTo(from, to, dayOfWeek);
    //     List<Train> availableTrains = new ArrayList<>();
        
        
    //     for (TrainSchedule schedule : schedules) {
    //         Train train = trainRepository.findById(schedule.getTrainId()).orElse(null);
    //         if (train != null) {
    //             availableTrains.add(train);
    //         }
    //     }

    //     return availableTrains;
    // }

    public List<TrainSchedule> getschedule(int from, int to, String date){
        String dayOfWeek = convertDateToDayOfWeek(date);
        return  trainScheduleRepository.findByFromAndTo(from, to, dayOfWeek);
    }

    public List<Quad> searchTrains1(int from, int to, String date) {
        // Convert date to day of the week
        String dayOfWeek = convertDateToDayOfWeek(date);
        
        // Fetch available trains based on the from, to stations, and dayOfWeek
        List<TrainSchedule> schedules = trainScheduleRepository.findByFromAndTo(from, to, dayOfWeek);
        List<Quad> availableTrains = new ArrayList<>();
        
        
        for (TrainSchedule schedule : schedules) {
            Train train = trainRepository.findById(schedule.getTrainId()).orElse(null);
            int s1=checkRepository.countAvailableSeats(schedule.getTrainId(),"GENERAL",dayOfWeek);
            int s2=checkRepository.countAvailableSeats(schedule.getTrainId(),"SLEEPER",dayOfWeek);
            int s3=checkRepository.countAvailableSeats(schedule.getTrainId(),"AC",dayOfWeek);
            if (train != null) {
                // availableTrains.add(train);
                availableTrains.add(new Quad(train, s1,s2,s3));
            }
        }

        return availableTrains;
    }

    private String convertDateToDayOfWeek(String date) {
        // Implement your date conversion logic here
        // This method should return the day of the week based on the input date
        // For example, using Java's LocalDate
        java.time.LocalDate localDate = java.time.LocalDate.parse(date);
        return localDate.getDayOfWeek().toString().toLowerCase(); // Convert to lower case to match your DB entries
    }
    public List<SeatInfo> getAvailableSeats(int trainId,String day,int trainId1, String coachType ) {
        try {
            return checkRepository.getAvailableSeats(trainId, day,trainId1, coachType);
        } catch (Exception e) {
            // Log the error (optional) and rethrow a custom exception or handle as needed
            throw new RuntimeException("Error while retrieving available seats", e);
        }
    }

    public void updateSeatStatus(int trainId, int coachNo, String day, int seatNo) {
        try {
            checkRepository.updateSeatStatus(trainId, coachNo, day, seatNo);
            System.out.println("Seat status updated successfully."+trainId+" "+ coachNo+ " " + day + " " + seatNo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update seat status: " + e.getMessage());
        }
    }


}
