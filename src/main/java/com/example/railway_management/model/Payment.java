package com.example.railway_management.model;

import java.util.Date;

public class Payment {

    private int transactionId;              // Primary key
    private Date transactionDate;           // Transaction date
    private String transactionTime;          // Transaction time in 'HH:MM:SS' format
    private String serviceOffered;           // Service offered (TICKET, FOOD, WASHROOM)
    private double amount;                   // Amount

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getServiceOffered() {
        return serviceOffered;
    }

    public void setServiceOffered(String serviceOffered) {
        this.serviceOffered = serviceOffered;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
