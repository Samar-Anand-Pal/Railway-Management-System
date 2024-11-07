package com.example.railway_management.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.example.railway_management.model.SeatInfo;
@Repository
public class CheckRepository {

    private final JdbcTemplate jdbcTemplate;

    public CheckRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for Integer (for seat count)
    // private static class SeatCountRowMapper implements RowMapper<Integer> {
    //     @Override
    //     public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
    //         return rs.getInt(1); // Get the first column as Integer
    //     }
    // }

    // Method to count available seats
    // public int countAvailableSeats(Long trainId, String seatType) {
    //     String sql = "SELECT COUNT(*) FROM seat WHERE train_id = ? AND seat_type = ? AND available = true";

    //     // Using the custom SeatCountRowMapper
    //     return jdbcTemplate.query(sql, new Object[]{trainId, seatType}, new SeatCountRowMapper())
    //                        .stream()
    //                        .findFirst()
    //                        .orElse(0); // Return 0 if no result
    // }
    public int countAvailableSeats(int trainId, String coachType, String day) {
        String sql = "SELECT COUNT(*) FROM seat WHERE train_id = ? AND day = ? AND seat_availability = 1 " +
                     "AND coach_no IN (SELECT coach_no FROM coach WHERE train_id = ? AND coach_type = ?)";
        
        // Pass all four parameters: trainId, day, trainId again, and coachType
        return jdbcTemplate.queryForObject(sql, Integer.class, trainId, day, trainId, coachType);
    }
public List<SeatInfo> getAvailableSeats(int trainId, String day,int trainId1, String coachType) {
    String sql = "SELECT seat_no, coach_no FROM seat WHERE train_id = ? AND day = ? AND seat_availability = 1 " +
                 "AND coach_no IN (SELECT coach_no FROM coach WHERE train_id = ? AND coach_type = ?) ";

    // Create a RowMapper instance
    RowMapper<SeatInfo> rowMapper = new RowMapper<>() {
        @Override
        public SeatInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            int seatNo = rs.getInt("seat_no");
            int coachNo = rs.getInt("coach_no");
            return new SeatInfo(seatNo, coachNo);
        }
    };
    return jdbcTemplate.query(sql, rowMapper, trainId, day, trainId, coachType);
    

    // Execute query and return list of SeatInfo
}


public void updateSeatStatus(int trainId, int coachNo, String day, int seatNo) {
    String sql = "UPDATE seat SET seat_availability = 0 " +
                 "WHERE train_id = ? AND coach_no = ? AND day = ? AND seat_no = ?";
    
    // Execute the update
    jdbcTemplate.update(sql, trainId, coachNo, day, seatNo);
}

   
    
    
}
