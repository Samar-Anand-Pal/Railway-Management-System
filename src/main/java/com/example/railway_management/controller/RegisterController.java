package com.example.railway_management.controller;

import com.example.railway_management.model.Users;
import com.example.railway_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        // model.addAttribute("user", new Users());
        return "register"; // Returns the register.html view
    }
    
    

    @PostMapping("/register")
    public String register(@ModelAttribute Users user, RedirectAttributes redirectAttributes) {
        try {
            user.setRole("USER");
            System.out.println("registering "+user.getUsername());
            userService.register(user);
            redirectAttributes.addFlashAttribute("registered", true);
            return "redirect:/login"; // Redirect to login after successful registration
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed.");
            return "redirect:/register"; // Redirect back to the registration page
        }
    }
    

}
