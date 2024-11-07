// package com.example.railway_management.model;

// public class Coach {

//     private int coachNo;                 // Unique identifier for each coach
//     private int trainId;                 // Foreign key referencing TRAIN table
//     private String coachType;             // Type of coach (SLEEPER, AC, GENERAL)
//     private int totalSeats;               // Total number of seats in the coach
//     private Integer availableSeats;       // Available seats in the coach (Integer to allow null)

//     // Getters and Setters
//     public int getCoachNo() {
//         return coachNo;
//     }

//     public void setCoachNo(int coachNo) {
//         this.coachNo = coachNo;
//     }

//     public int getTrainId() {
//         return trainId;
//     }

//     public void setTrainId(int trainId) {
//         this.trainId = trainId;
//     }

//     public String getCoachType() {
//         return coachType;
//     }

//     public void setCoachType(String coachType) {
//         this.coachType = coachType;
//     }

//     public int getTotalSeats() {
//         return totalSeats;
//     }

//     public void setTotalSeats(int totalSeats) {
//         this.totalSeats = totalSeats;
//     }

//     public Integer getAvailableSeats() {
//         return availableSeats;
//     }

//     public void setAvailableSeats(Integer availableSeats) {
//         this.availableSeats = availableSeats;
//     }
// }


package com.example.railway_management.model;

public class Coach {

    private int coachNo;              // Unique identifier for each coach
    private int trainId;              // Foreign key referencing TRAIN table

 
    private String coachType;      // Type of coach (SLEEPER, AC, GENERAL)

    // Enum for Coach Type
    

    // Default constructor
    public Coach() {
    }

    // Parameterized constructor
    public Coach(int coachNo, int trainId, String coachType) {
        this.coachNo = coachNo;
        this.trainId = trainId;
        this.coachType = coachType;
    }

    // Getters and Setters
    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachNo=" + coachNo +
                ", trainId=" + trainId +
                ", coachType=" + coachType +
                '}';
    }
}
