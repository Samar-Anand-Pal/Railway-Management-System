package com.example.railway_management.service;
import org.springframework.stereotype.Service;
import com.example.railway_management.model.Admin;
import com.example.railway_management.repository.AdminRepository;

@Service
public class AdminService {

    private  AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public  boolean authenticate(String username, String password) {
        Admin admin = adminRepository.findByUsername(username);
        return admin != null && admin.getPassword().equals(password); // Implement proper password hashing in production
    }
}
