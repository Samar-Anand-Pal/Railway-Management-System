package com.example.railway_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.railway_management.repository.TrainRepository;
@Service
public class TrainService {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    // Method to get train type
    public String getTrainType(int trainId) {
        return trainRepository.getTrainTypeById(trainId);
    }
}
