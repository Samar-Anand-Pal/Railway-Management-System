package com.example.railway_management.repository;

import com.example.railway_management.model.FoodService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FoodServiceRepository {

    private final JdbcTemplate jdbcTemplate;

    public FoodServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping result set to FoodService model
    private static class FoodServiceRowMapper implements RowMapper<FoodService> {
        @Override
        public FoodService mapRow(ResultSet rs, int rowNum) throws SQLException {
            FoodService foodItem = new FoodService();
            foodItem.setFoodName(rs.getString("FOOD_NAME"));
            foodItem.setPrice(rs.getDouble("PRICE"));
            return foodItem;
        }
    }

    // Method to fetch all food items from FOOD_SERVICE table
    public List<FoodService> getAllFoodItems() {
        String sql = "SELECT FOOD_NAME, PRICE FROM FOOD_SERVICE";
        return jdbcTemplate.query(sql, new FoodServiceRowMapper());
    }

    public double getFoodPriceByFoodName(String foodName) {
        String sql = "SELECT price FROM food_service WHERE FOOD_NAME = ?";
        try {
            // Query the price directly from the database and return it as a double
            return jdbcTemplate.queryForObject(sql, new Object[]{foodName}, Double.class);
        } catch (Exception e) {
            return 0.0; // Return 0 if no food item is found or an error occurs
        }
    }
    

}
