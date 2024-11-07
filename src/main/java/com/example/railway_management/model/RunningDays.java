package com.example.railway_management.model;

public class RunningDays {

    private int trainId;            // Foreign key referencing TRAIN table
    private String dayRunning;      // Day on which the train is running

    // Getters and Setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getDayRunning() {
        return dayRunning;
    }

    public void setDayRunning(String dayRunning) {
        this.dayRunning = dayRunning;
    }
}
