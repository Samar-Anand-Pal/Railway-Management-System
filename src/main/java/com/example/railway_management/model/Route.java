package com.example.railway_management.model;
public class Route {

    private int routeId;
    private int srcStationId;
    private int destinationStationId;
    private double totalDistance;
    private String duration;  // Stored as String in 'HH:MM:SS' format
    private String day;

    // Getters and Setters
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getSrcStationId() {
        return srcStationId;
    }

    public void setSrcStationId(int srcStationId) {
        this.srcStationId = srcStationId;
    }

    public int getDestinationStationId() {
        return destinationStationId;
    }

    public void setDestinationStationId(int destinationStationId) {
        this.destinationStationId = destinationStationId;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
