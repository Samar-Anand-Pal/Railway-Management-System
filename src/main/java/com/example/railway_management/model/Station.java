// package com.example.railway_management.model;

// import java.sql.Time;

// public class Station {

//     private int stationId;
//     private String stationName;
//     private int noOfPlatforms;
//     private Time openingTime;   // Changed to Time
//     private Time closingTime;   // Changed to Time
//     private String city;
//     private String state;
//     private String country;
//     private String zipCode;

//     // Getters and Setters
//     public int getStationId() {
//         return stationId;
//     }

//     public void setStationId(int stationId) {
//         this.stationId = stationId;
//     }

//     public String getStationName() {
//         return stationName;
//     }

//     public void setStationName(String stationName) {
//         this.stationName = stationName;
//     }

//     public int getNoOfPlatforms() {
//         return noOfPlatforms;
//     }

//     public void setNoOfPlatforms(int noOfPlatforms) {
//         this.noOfPlatforms = noOfPlatforms;
//     }

//     public Time getOpeningTime() {
//         return openingTime;
//     }

//     public void setOpeningTime(Time openingTime) {
//         this.openingTime = openingTime;
//     }

//     public Time getClosingTime() {
//         return closingTime;
//     }

//     public void setClosingTime(Time closingTime) {
//         this.closingTime = closingTime;
//     }

//     public String getCity() {
//         return city;
//     }

//     public void setCity(String city) {
//         this.city = city;
//     }

//     public String getState() {
//         return state;
//     }

//     public void setState(String state) {
//         this.state = state;
//     }

//     public String getCountry() {
//         return country;
//     }

//     public void setCountry(String country) {
//         this.country = country;
//     }

//     public String getZipCode() {
//         return zipCode;
//     }

//     public void setZipCode(String zipCode) {
//         this.zipCode = zipCode;
//     }
// }
package com.example.railway_management.model;

public class Station {

    private int stationId;
    private String stationName;
    private int noOfPlatforms;
    private String pinCode;  // Updated from zipCode to pinCode

    // Default constructor
    public Station() {
    }

    // Parameterized constructor
    public Station(int stationId, String stationName, int noOfPlatforms, String pinCode) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.noOfPlatforms = noOfPlatforms;
        this.pinCode = pinCode;
    }

    // Getters and Setters
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getNoOfPlatforms() {
        return noOfPlatforms;
    }

    public void setNoOfPlatforms(int noOfPlatforms) {
        this.noOfPlatforms = noOfPlatforms;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", noOfPlatforms=" + noOfPlatforms +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
