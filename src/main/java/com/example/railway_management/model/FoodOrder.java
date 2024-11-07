// package com.example.railway_management.model;

// public class FoodOrder {

//     private int orderId;                 // Primary key, auto-incremented
//     private int passengerId;             // Foreign key referencing PASSENGER table
//     private String foodName;              // Foreign key referencing FOOD_SERVICE table

//     // Getters and Setters
//     public int getOrderId() {
//         return orderId;
//     }

//     public void setOrderId(int orderId) {
//         this.orderId = orderId;
//     }

//     public int getPassengerId() {
//         return passengerId;
//     }

//     public void setPassengerId(int passengerId) {
//         this.passengerId = passengerId;
//     }

//     public String getFoodName() {
//         return foodName;
//     }

//     public void setFoodName(String foodName) {
//         this.foodName = foodName;
//     }
// }


package com.example.railway_management.model;

public class FoodOrder {

    private int orderId;                  // Primary key, auto-incremented
    private int ticketId;                 // Foreign key referencing TICKET table
    private String foodName;               // Foreign key referencing FOOD_SERVICE table
    private int quantity;                  // Quantity of food items ordered

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
