package com.example.railway_management.model;

public class Train {
    private Integer trainId;
    private String trainName;

    // Define an Enum for trainType based on database constraints
    
    private String trainType;
    private String status; // Added status field

    // Default constructor
    public Train() {
    }

    // Parameterized constructor
    public Train(Integer trainId, String trainName, String trainType, String status) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainType = trainType;
        this.status = status; // Initialize status
    }

    // Getters and Setters
    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", trainName='" + trainName + '\'' +
                ", trainType=" + trainType +
                ", status='" + status + '\'' +
                '}';
    }
}
