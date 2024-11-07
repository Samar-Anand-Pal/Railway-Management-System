package com.example.railway_management.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.railway_management.model.Admin;

@Repository
public class AdminRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Custom query to find admin by username
    public  Admin findByUsername(String username) {
        String sql = "SELECT * FROM admin WHERE username = ?";
        try {
            System.out.println("Entered repository -- findByUsername");
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, new AdminRowMapper());
        } catch (Exception e) {
            // Handle case where no admin is found
            return null;
        }
    }

    // RowMapper for mapping all admin fields
    private static class AdminRowMapper implements RowMapper<Admin> {
        @Override
        public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("Entered admin row mapper");
            Admin admin = new Admin();
            admin.setId(rs.getInt("id"));
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            System.out.println("Exited admin row mapper");
            return admin;
        }
    }
}
