package com.example.railway_management.model;

public class SeatNo {

    private int ticketId;  // Foreign key referencing TICKET table
    private int seatNo;    // Foreign key referencing SEAT table

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
