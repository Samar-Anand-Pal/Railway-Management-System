// package com.example.railway_management.controller;

// import com.example.railway_management.model.User; // Import the User model class
// import com.example.railway_management.model.Employee;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import com.example.railway_management.service.EmployeeService;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.ui.Model;  






// @Controller
// public class EmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @GetMapping("/employee_login")
//     public String showEmployeeLoginPage() {
//         System.out.println("entered employee login");
//         return "employee_login"; // Renders employee_login.html
//     }
    
//     // @PostMapping("/employee_login")
//     // public String authenticateEmployee(@RequestParam("employeeId") int employeeId,
//     //                                    @RequestParam("phoneNumber") String phoneNumber,
//     //                                    Model model) {

//     //             System.out.println("employee_controller_post_called");

//     //     // Authenticate employee using employeeId and phoneNumber
//     //     boolean isAuthenticated = employeeService.authenticate(employeeId, phoneNumber);
//     //     System.out.println(isAuthenticated);
//     //     if (isAuthenticated) {
//     //         System.out.println("user is authenticated in controller");
//     //         // Redirect to employee home if authentication is successful
//     //         return "employee_home"; // Renders employee_home.html
//     //     } else {
//     //         // Add error message to the model
//     //         model.addAttribute("error", "Invalid Employee ID or Phone Number. Please try again.");
//     //         return "employee_login"; // Renders employee_login.html with error message
//     //     }
//     // }
//     @PostMapping("/employee_login")
//     public String authenticateEmployee(@RequestParam("employeeId") int employeeId,
//                                        @RequestParam("phoneNumber") String phoneNumber,
//                                        Model model,
//                                        RedirectAttributes redirectAttributes) {

//         System.out.println("employee_controller_post_called");

//         // Authenticate employee using employeeId and phoneNumber
        
//         boolean isAuthenticated = employeeService.authenticate(employeeId, phoneNumber);
//         System.out.println(isAuthenticated);

//         if (isAuthenticated) {
//             System.out.println("user is authenticated in controller");
//             // Redirect to employee home if authentication is successful
//             Employee authenticatedEmployee= employeeService.findAuthenticatedEmployee(employeeId, phoneNumber);
//             if(authenticatedEmployee==null) System.out.println("samar");
            
//             model.addAttribute("emp", authenticatedEmployee);
//             return "employee_home"; // Redirects to employee_home (better than direct render)
//         } else {
//             // Add error message to the redirect attributes for POST/REDIRECT/GET pattern
//             redirectAttributes.addFlashAttribute("error", "Invalid Employee ID or Phone Number. Please try again.");
//             return "redirect:/employee_login"; // Redirects back to login with error message
//         }
//     }
// }

package com.example.railway_management.controller;

// import com.example.railway_management.model.User; // Import the User model class
import com.example.railway_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.railway_management.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;  

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // @GetMapping("/employee_login")
    // public String showEmployeeLoginPage() {
    //     System.out.println("entered employee login");
    //     return "employee_login"; // Renders employee_login.html
    // }
    
    // @PostMapping("/employee_login")
    // public String authenticateEmployee(@RequestParam("employeeId") int employeeId,
    //                                    @RequestParam("phoneNumber") String phoneNumber,
    //                                    Model model) {

    //             System.out.println("employee_controller_post_called");

    //     // Authenticate employee using employeeId and phoneNumber
    //     boolean isAuthenticated = employeeService.authenticate(employeeId, phoneNumber);
    //     System.out.println(isAuthenticated);
    //     if (isAuthenticated) {
    //         System.out.println("user is authenticated in controller");
    //         // Redirect to employee home if authentication is successful
    //         return "employee_home"; // Renders employee_home.html
    //     } else {
    //         // Add error message to the model
    //         model.addAttribute("error", "Invalid Employee ID or Phone Number. Please try again.");
    //         return "employee_login"; // Renders employee_login.html with error message
    //     }
    // }
    @GetMapping("/employee-login")
    public String authenticateEmployee(
                                       Model model,
                                       RedirectAttributes redirectAttributes) {

        System.out.println("employee_controller_post_called");
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         // The role (e.g., ROLE_ADMIN, ROLE_USER, etc.)
         String username = principal.getUsername();
         Employee authenticatedEmployee= employeeService.findAuthenticatedEmployee(username);
        // Authenticate employee using employeeId and phoneNumber
        
        // boolean isAuthenticated = employeeService.authenticate(employeeId, phoneNumber);
        // System.out.println(isAuthenticated);

        // if (isAuthenticated) {
            System.out.println("user is authenticated in controller");
            // Redirect to employee home if authentication is successful
            // if(authenticatedEmployee==null) System.out.println("samar");
            System.out.println("username"+authenticatedEmployee.getUsername());
            model.addAttribute("emp", authenticatedEmployee);
            return "employee_home"; // Redirects to employee_home (better than direct render)
        // } else {
        //     // Add error message to the redirect attributes for POST/REDIRECT/GET pattern
        //     redirectAttributes.addFlashAttribute("error", "Invalid Employee ID or Phone Number. Please try again.");
        //     return "redirect:/employee_login"; // Redirects back to login with error message
        // }
    }
}