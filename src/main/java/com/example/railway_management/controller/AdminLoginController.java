// package com.example.railway_management.controller;
// import java.util.*;
// import com.example.railway_management.service.EmployeeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.example.railway_management.model.Employee;
// import com.example.railway_management.service.AdminService;
// // import com.example.railway_management.service.EmployeeService;


// @Controller
// public class AdminLoginController {

//     @Autowired
//     private AdminService adminService;

//      @Autowired
//     private EmployeeService employeeService;

//     @GetMapping("/admin-login")
//     public String showAdminLogin() {
//         return "admin-login"; // Returns the view name for the admin login page
//     }

//     @PostMapping("/admin-login")
//     public String handleAdminLogin(@RequestParam String username, 
//                                     @RequestParam String password, 
//                                     Model model) {
//         // Replace this with actual authentication logic
//         if (adminService.authenticate(username, password))  {
//             // Redirect to admin dashboard or home page on successful login
//             List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
//             model.addAttribute("activeEmployees" , activeEmployees);
//             List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
//             model.addAttribute("inactiveEmployees" , inactiveEmployees);
//             List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
//             model.addAttribute("terminatedEmployees" , termminatedEmployees);

// System.out.println("antsant" + termminatedEmployees.size());

//             return "admin-dashboard"; // Change this to your actual dashboard path

//         } else {
//             // Add an error message and return to login page
//             model.addAttribute("error", true);
//             return "admin-login";
//         }
//     }

//     // Dummy method for admin validation (replace with your actual logic)
 
// }

package com.example.railway_management.controller;
import java.util.*;
import com.example.railway_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.railway_management.model.Employee;
import com.example.railway_management.service.AdminService;
// import com.example.railway_management.service.EmployeeService;


@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

     @Autowired
    private EmployeeService employeeService;

    // @GetMapping("/admin-login")
    // public String showAdminLogin() {
    //     return "admin-login"; // Returns the view name for the admin login page
    // }

    @GetMapping("/admin-login")
    public String handleAdminLogin(
                                    // @RequestParam String username, 
                                    // @RequestParam String password, 
                                    Model model) {
        // Replace this with actual authentication logic
        // if (adminService.authenticate(username, password))  {
            // Redirect to admin dashboard or home page on successful login
            List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
            model.addAttribute("activeEmployees" , activeEmployees);
            List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
            model.addAttribute("inactiveEmployees" , inactiveEmployees);
            List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
            model.addAttribute("terminatedEmployees" , termminatedEmployees);

            System.out.println("antsant" + termminatedEmployees.size());

            return "admin-dashboard"; // Change this to your actual dashboard path

        // } else {
        //     // Add an error message and return to login page
        //     model.addAttribute("error", true);
        //     return "admin-login";
        // }
    }

    // Dummy method for admin validation (replace with your actual logic)
 
}