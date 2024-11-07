// package com.example.railway_management.service;

// import com.example.railway_management.model.Users;
// import com.example.railway_management.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import java.util.Collections;
// import java.util.Optional;

// @Service
// public class UserService implements UserDetailsService {

//     @Autowired
//     private JdbcTemplate jdbcTemplate;

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Optional<Users> optionalUser = userRepository.findByUsername(username);
//         Users user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

//         GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

//         return new org.springframework.security.core.userdetails.User(
//                 user.getUsername(),
//                 user.getPassword(),
//                 true, true, true, true,
//                 Collections.singletonList(authority)
//         );
//     }

//     public void register(Users user) {
//         userRepository.save(user); // Directly saves without encoding
//     }
    
//     public boolean authenticate(String username, String password) {
//         Optional<Users> optionalUser = userRepository.findByUsername(username);
        
//         // Check if user exists and compare passwords
//         if (optionalUser.isPresent()) {
//             Users user = optionalUser.get();
//             return user.getPassword().equals(password); // Compare stored password with input
//         }
        
//         return false; // User not found
//     }
// }
package com.example.railway_management.service;

import com.example.railway_management.model.Users;
import com.example.railway_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Initialize here
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
    
    public void register(Users user) {
        System.out.println("registering here "+user.getRole());
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        userRepository.save(user); // Save the user to the repository
        System.out.println("registering hering "+user.getUsername());
    }
}
