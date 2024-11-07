package com.example.railway_management.model;

public class User {
    private Long id;
    private String username;
    private String password; // Consider storing a hashed version
    private String role;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password; // Hash this before storing
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password; // Return hashed password if stored
    }

    public void setPassword(String password) {
        this.password = password; // Hash before setting
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
