package com.example.railway_management.service;

import com.example.railway_management.model.Passenger;
import com.example.railway_management.model.Ticket;
import com.example.railway_management.model.Train;
import com.example.railway_management.repository.PassengerRepository;
import com.example.railway_management.repository.TicketRepository;
import com.example.railway_management.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private PassengerRepository passengerRepository; // Repository for Passenger

    @Autowired
    private TicketRepository ticketRepository; // Repository for Ticket

    // Method to save a Ticket
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);  // Save the ticket using the TicketRepository
    }

    // Method to save multiple Passengers
    public void savePassengers(List<Passenger> passengers) {
        passengerRepository.saveAll(passengers);
    }

    // Method to find a Train by ID
    public Train findById1(int trainId) {
        return trainRepository.findById(trainId).orElse(null);
    }

    public List<Ticket> getTicketsByUsername(String username) {
        return ticketRepository.findTicketsByUsername(username);
    }
}
