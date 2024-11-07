package com.example.railway_management.model;

public class Facilities {

    private int stationId;                    // Foreign key referencing STATION table
    private String facilitiesProvided;         // Description of facilities provided

    // Getters and Setters
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getFacilitiesProvided() {
        return facilitiesProvided;
    }

    public void setFacilitiesProvided(String facilitiesProvided) {
        this.facilitiesProvided = facilitiesProvided;
    }
}
