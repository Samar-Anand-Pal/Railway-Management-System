package com.example.railway_management.service;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.util.Optional;

// import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
// import org.springframework.web.bind.annotation.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.railway_management.model.Users;
import com.example.railway_management.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomUserService implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepository U;

    
    @Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {

    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();

    String redirectUrl = "";
    // Use Optional to get the user
    Optional<Users> userOptional = U.findByUsername(username);
    if (userOptional.isPresent()) {
        Users user = userOptional.get();
        // Long userId = user.getId();  // Uncomment if you need to use the user ID

        // Define your redirection logic here based on role
        redirectUrl = "/home";
        // for (GrantedAuthority authority : authorities) {
        //     if (authority.getAuthority().equals("USER")) {
        //         redirectUrl = "/info";
        //         break;
        //     } else if (authority.getAuthority().equals("EMPLOYEE")) {
        //         redirectUrl = "/employee";
        //         break;
        //     }
        //     else if (authority.getAuthority().equals("ADMIN")) {
        //         redirectUrl = "/admin";
        //         break;
        //     }
        //     else if (authority.getAuthority().equals("RENTER")) {
        //         redirectUrl = "/renter";
        //         break;
        //     }
        // }

        if (!redirectUrl.isEmpty()) {
            response.sendRedirect(redirectUrl);
        } else {
            throw new IllegalStateException("No redirect URL specified");
        }
    } else {
        throw new IllegalStateException("User not found");
    }
}

}