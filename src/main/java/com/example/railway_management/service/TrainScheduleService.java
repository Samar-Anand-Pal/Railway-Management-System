package com.example.railway_management.service;

import com.example.railway_management.model.TrainSchedule;
import com.example.railway_management.repository.TrainScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TrainScheduleService {

    private final TrainScheduleRepository trainScheduleRepository;

    public TrainScheduleService(TrainScheduleRepository trainScheduleRepository) {
        this.trainScheduleRepository = trainScheduleRepository;
    }

    public List<TrainSchedule> getScheduleByStationAndTrainId(int stationId, int trainId) {
        return trainScheduleRepository.findByStationAndTrainId(stationId, trainId);
    }

    public double getTimeDifferenceInFractionalHours(int trainId, int fromStationId, int toStationId, String date) {
       // Assuming getArrivalTime returns LocalDateTime
LocalDateTime fromArrivalDateTime = trainScheduleRepository.getArrivalTime(trainId, fromStationId, date);
LocalDateTime toArrivalDateTime = trainScheduleRepository.getArrivalTime(trainId, toStationId, date);

// Extracting LocalTime from LocalDateTime
LocalTime fromArrivalTime = fromArrivalDateTime != null ? fromArrivalDateTime.toLocalTime() : null;
LocalTime toArrivalTime = toArrivalDateTime != null ? toArrivalDateTime.toLocalTime() : null;


        if (fromArrivalTime != null && toArrivalTime != null) {
            Duration duration = Duration.between(fromArrivalTime, toArrivalTime);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            // Convert the time difference to fractional hours
            return hours + (minutes / 60.0);
        } else {
            throw new IllegalArgumentException("Invalid station ID or date provided.");
        }
    }
}
