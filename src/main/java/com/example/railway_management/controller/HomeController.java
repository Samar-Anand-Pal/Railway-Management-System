package com.example.railway_management.controller;

import com.example.railway_management.model.Train;
// import com.example.railway_management.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;  
import com.example.railway_management.model.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
// @SessionAttributes({"username"})
public class HomeController {

   

    @GetMapping("/home")
    public String home(Model model) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=principal.getUsername();
        String role = principal.getAuthorities().toString();  // or just "ROLE_" + role if you use roles like "ROLE_ADMIN"
        
        // Add the role to the model to be used in the home.html
        model.addAttribute("role", role);

        model.addAttribute("username",username);
        return "home";  // This maps to home.html
    }

}
