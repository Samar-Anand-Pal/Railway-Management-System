package com.example.railway_management.repository;

import com.example.railway_management.model.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Find a user by username.
     *
     * @param username the username to search for
     * @return an Optional containing the user if found, or empty if not found
     */
    public Optional<Users> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, rs -> {
            if (rs.next()) {
                return Optional.of(mapRowToUser(rs));
            }
            return Optional.empty();
        });
    }

    /**
     * Save a new user to the database.
     *
     * @param user the user to save
     */
    public void save(Users user) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole());
    }

    /**
     * Map a ResultSet row to a Users object.
     *
     * @param rs the ResultSet
     * @return a Users object
     * @throws SQLException if any SQL error occurs
     */
    private Users mapRowToUser(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        String password = rs.getString("password");
        String role = rs.getString("role");

        return new Users(username, password, role);
    }
}
