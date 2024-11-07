package com.example.railway_management.model;

// Import the Train class from the same package
import com.example.railway_management.model.Train;

public class Quad {
    private Train t; // Attribute of type Train
    private int generalSeats; // Number of general seats
    private int sleeperSeats; // Number of sleeper seats
    private int acSeats; // Number of AC seats

    // Constructor for t (Train model)
    public Quad(Train t, int generalSeats, int sleeperSeats, int acSeats) {
        this.t = t;
        this.generalSeats = generalSeats;
        this.sleeperSeats = sleeperSeats;
        this.acSeats = acSeats;
    }

    // Constructor for basic Quad without t (Train model)
    public Quad(int generalSeats, int sleeperSeats, int acSeats) {
        this.t = null; // t can be null if not specified
        this.generalSeats = generalSeats;
        this.sleeperSeats = sleeperSeats;
        this.acSeats = acSeats;
    }

    // Getters
    public Train getT() {
        return t;
    }

    public int getGeneralSeats() {
        return generalSeats;
    }

    public int getSleeperSeats() {
        return sleeperSeats;
    }

    public int getAcSeats() {
        return acSeats;
    }

    // Setters
    public void setT(Train t) {
        this.t = t;
    }

    public void setGeneralSeats(int generalSeats) {
        this.generalSeats = generalSeats;
    }

    public void setSleeperSeats(int sleeperSeats) {
        this.sleeperSeats = sleeperSeats;
    }

    public void setAcSeats(int acSeats) {
        this.acSeats = acSeats;
    }

    // Method to display Quad details
    @Override
    public String toString() {
        String tInfo = (t != null) ? t.toString() : "No model";
        return "Quad Model: " + tInfo +
               ", General Seats: " + generalSeats +
               ", Sleeper Seats: " + sleeperSeats +
               ", AC Seats: " + acSeats;
    }
}
