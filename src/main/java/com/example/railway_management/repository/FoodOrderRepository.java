package com.example.railway_management.repository;

import com.example.railway_management.model.FoodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodOrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Insert a new food order into the food_order table
    public void saveFoodOrder(FoodOrder foodOrder) {
        String sql = "INSERT INTO food_order (Ticket_id, food_name, quantity) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, foodOrder.getTicketId(), foodOrder.getFoodName(), foodOrder.getQuantity());
    }

    // Retrieve all food orders by ticket ID
    public List<FoodOrder> findByTicketId(int ticketId) {
        String sql = "SELECT * FROM food_order WHERE Ticket_id = ?";
        
        // Map each row of the result to a FoodOrder object
        return jdbcTemplate.query(sql, new Object[]{ticketId}, foodOrderRowMapper());
    }

    // RowMapper to map result set to FoodOrder object
    private RowMapper<FoodOrder> foodOrderRowMapper() {
        return (rs, rowNum) -> {
            FoodOrder foodOrder = new FoodOrder();
            foodOrder.setOrderId(rs.getInt("order_id"));
            foodOrder.setTicketId(rs.getInt("Ticket_id"));
            foodOrder.setFoodName(rs.getString("food_name"));
            foodOrder.setQuantity(rs.getInt("quantity"));
            return foodOrder;
        };
    }
}
