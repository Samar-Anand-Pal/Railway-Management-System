package com.example.railway_management.repository;

import com.example.railway_management.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class TicketRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to save a single ticket and retrieve the generated ticketId
    public void save(Ticket ticket) {
        String sql = "INSERT INTO Ticket (train_id, Boarding_Station, Destination_Station, Date_of_Journey, Booking_Date, Class , username) VALUES (?, ?, ?, ?, ?, ?, ?)";
        System.out.println("Entered from Ticket repository");
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ticket.getTrainId()); 
            ps.setInt(2, ticket.getBoardingStation()); // Set boarding station as String
            ps.setInt(3, ticket.getDestinationStation()); // Set destination station as String
            ps.setDate(4, java.sql.Date.valueOf(ticket.getDateOfJourney())); 
            ps.setDate(5, java.sql.Date.valueOf(ticket.getBookingDate()));  
            ps.setString(6, ticket.getTicketClass());
            ps.setString(7, ticket.getUsername());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            ticket.setTicketId(keyHolder.getKey().intValue());
        }
        System.out.println("Exited from ticket repository");
    }

    // Method to fetch tickets based on username
    public List<Ticket> findTicketsByUsername(String username) {
        String sql = "SELECT * FROM ticket WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, new TicketRowMapper());
    }

    // RowMapper for mapping ResultSet to Ticket object
    private static class TicketRowMapper implements RowMapper<Ticket> {
        @Override
        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setTicketId(rs.getInt("Ticket_Id"));
            ticket.setTrainId(rs.getInt("train_id"));
            ticket.setBoardingStation(rs.getInt("Boarding_Station"));
            ticket.setDestinationStation(rs.getInt("Destination_Station"));
            ticket.setDateOfJourney(rs.getDate("Date_of_Journey").toLocalDate()); 
            ticket.setBookingDate(rs.getDate("Booking_Date").toLocalDate());  
            ticket.setTicketClass(rs.getString("Class"));
            ticket.setUsername(rs.getString("username"));
            return ticket;
        }
    }
}
