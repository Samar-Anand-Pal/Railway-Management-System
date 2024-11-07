package com.example.railway_management.service;

import com.example.railway_management.model.TrainSchedule;
import com.example.railway_management.repository.TrainEnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TrainEnquiryService {

    private final TrainEnquiryRepository trainEnquiryRepository;

    @Autowired
    public TrainEnquiryService(TrainEnquiryRepository trainEnquiryRepository) {
        this.trainEnquiryRepository = trainEnquiryRepository;
    }

    public List<TrainSchedule> getTrainScheduleById(int trainId) {
        return trainEnquiryRepository.findTrainScheduleById(trainId);
    }
}
