// package com.example.railway_management.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.railway_management.service.UserService;
// // // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.annotation.AuthenticationPrincipal;
// // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @Controller
// public class AuthController {

//     // @Autowired
//     // private AuthenticationManager authenticationManager;
    
//     @Autowired
//     private UserService userService;

//     @GetMapping("/login")
//     public String showLoginPage() {
//         return "login"; // Return the login HTML page
//     }

//     @PostMapping("/login")
//     public String login(@RequestParam("username") String username,
//                         @RequestParam("password") String password,
//                         @RequestParam("role") String role,
//                         Model model) {
                         
//                             System.out.println("heloooooooo ");
//                             boolean flag=userService.authenticate(username,password);
      
//             // Authentication auth = authenticationManager.authenticate(
//             //     new UsernamePasswordAuthenticationToken(username, password));
//             // If authentication is successful, you can redirect to a welcome page or the homepage
//             if(flag){

//                 return "redirect:/home"; // Redirect to the home page on successful login
//             }
//             else{

//                 model.addAttribute("error", true);
//                 return "login"; // Redirect back to login page with error
//             }
        
//     }
// }
package com.example.railway_management.controller;
import org.springframework.ui.Model;  
import com.example.railway_management.model.User; // Import the User model class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager; // Autowire the AuthenticationManager

    @GetMapping("/login")
    public String login() {
        System.out.println("Received GET request to login");
        return "login"; // Returns the login.html view
    }

    // @PostMapping("/login")
    // public String login(@ModelAttribute User user, RedirectAttributes redirectAttributes , Model model) {
    //     try {
    //         System.out.println("Received POST TRY request to login");
    //         // Attempt to authenticate the user
          
    //         Authentication authentication = authenticationManager.authenticate(
    //                 new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    //         SecurityContextHolder.getContext().setAuthentication(authentication); // Set authentication in security context
            
    //         return "redirect:/home"; // Redirect to home after successful login
    //     } catch (Exception e) {
    //         System.out.println("Received POST CATCH request to login");
    //         redirectAttributes.addFlashAttribute("errorMessage", "Invalid username or password.");
    //         return "redirect:/login?error=true"; // Redirect back to the login page with the error parameter
    //     }
    // }
}
