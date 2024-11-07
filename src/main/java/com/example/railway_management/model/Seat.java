// package com.example.railway_management.model;

// public class Seat {
//     private Long trainId;
//     private String coachNo;
//     private String seatNo;
//     private String seatType;
//     private Boolean seatAvailability;
//     private Double price;

//     // Getters and Setters
//     public Long getTrainId() {
//         return trainId;
//     }

//     public void setTrainId(Long trainId) {
//         this.trainId = trainId;
//     }

//     public String getCoachNo() {
//         return coachNo;
//     }

//     public void setCoachNo(String coachNo) {
//         this.coachNo = coachNo;
//     }

//     public String getSeatNo() {
//         return seatNo;
//     }

//     public void setSeatNo(String seatNo) {
//         this.seatNo = seatNo;
//     }

//     public String getSeatType() {
//         return seatType;
//     }

//     public void setSeatType(String seatType) {
//         this.seatType = seatType;
//     }

//     public Boolean getSeatAvailability() {
//         return seatAvailability;
//     }

//     public void setSeatAvailability(Boolean seatAvailability) {
//         this.seatAvailability = seatAvailability;
//     }

//     public Double getPrice() {
//         return price;
//     }

//     public void setPrice(Double price) {
//         this.price = price;
//     }
// }
package com.example.railway_management.model;


public class Seat {
    private int trainId;                   // Train ID (Foreign key)
    private int coachNo;                   // Coach number (Foreign key)
    private int seatNo;                    // Seat number
    private boolean seatAvailability;       // Seat availability status
    private String day;                       // ENUM for days of the week



 

    // Default constructor
    public Seat() {
    }

    // Parameterized constructor
    public Seat(int trainId, int coachNo, int seatNo, boolean seatAvailability, String day) {
        this.trainId = trainId;
        this.coachNo = coachNo;
        this.seatNo = seatNo;
        this.seatAvailability = seatAvailability;
        this.day = day;
    }

    // Getters and Setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

   
    public boolean isSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(boolean seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "trainId=" + trainId +
                ", coachNo=" + coachNo +
                ", seatNo=" + seatNo +
                ", seatAvailability=" + seatAvailability +
                ", day=" + day +
                '}';
    }
}
