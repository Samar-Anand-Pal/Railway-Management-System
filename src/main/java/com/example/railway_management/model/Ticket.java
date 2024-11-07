package com.example.railway_management.model;

import java.time.LocalDate;

public class Ticket {

    private int ticketId;
    private int trainId;               // Added trainId to reference the train
    private int boardingStation;       // Changed to int to reference station ID
    private int destinationStation;    // Changed to int to reference station ID
    private LocalDate dateOfJourney;   // Type is LocalDate to match DATE type in schema
    private LocalDate bookingDate;     // Type is LocalDate to match DATE type in schema
    private String ticketClass;        // Class name (Class is a reserved word, so renamed to ticketClass)
    private String username;           // Added username to reference the User table

    // Default constructor
    public Ticket() {
    }

    // Parameterized constructor
    public Ticket(int ticketId, int trainId, int boardingStation, int destinationStation,
                  LocalDate dateOfJourney, LocalDate bookingDate, String ticketClass, String username) {
        this.ticketId = ticketId;
        this.trainId = trainId;
        this.boardingStation = boardingStation;
        this.destinationStation = destinationStation;
        this.dateOfJourney = dateOfJourney;
        this.bookingDate = bookingDate;
        this.ticketClass = ticketClass;
        this.username = username;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getBoardingStation() {
        return boardingStation;
    }

    public void setBoardingStation(int boardingStation) {
        this.boardingStation = boardingStation;
    }

    public int getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(int destinationStation) {
        this.destinationStation = destinationStation;
    }

    public LocalDate getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(LocalDate dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", trainId=" + trainId +
                ", boardingStation=" + boardingStation +
                ", destinationStation=" + destinationStation +
                ", dateOfJourney=" + dateOfJourney +
                ", bookingDate=" + bookingDate +
                ", ticketClass='" + ticketClass + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
