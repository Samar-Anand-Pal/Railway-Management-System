package com.example.railway_management.model;

public class SeatInfo {
    private int seatNo;
    private int coachNo;

    public SeatInfo(int seatNo, int coachNo) {
        this.seatNo = seatNo;
        this.coachNo = coachNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }
}
