// package com.example.railway_management.controller;
// import java.util.*;
// import com.example.railway_management.model.Employee;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

// import com.example.railway_management.service.EmployeeService;
// import org.springframework.ui.Model;

// @Controller
// public class DeleteEmployeeController {

//     @Autowired
//     private EmployeeService employeeService;

//     @PostMapping("/delete-employee/{id}")
//     public String deleteEmployee(@PathVariable("id") int employeeId,Model model) {
//         employeeService.deleteEmployee(employeeId); // Call the service to delete the employee
//         List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
//         model.addAttribute("activeEmployees" , activeEmployees);
//         List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
//         model.addAttribute("inactiveEmployees" , inactiveEmployees);
//         List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
//         model.addAttribute("terminatedEmployees" , termminatedEmployees);
//          // Redirect to the admin dashboard
//         return "admin-dashboard";
//     }
// }

package com.example.railway_management.controller;
import java.util.*;
import com.example.railway_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.railway_management.service.EmployeeService;
import org.springframework.ui.Model;

@Controller
public class DeleteEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") int employeeId,Model model) {
        employeeService.deleteEmployee(employeeId); // Call the service to delete the employee
        List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
        model.addAttribute("activeEmployees" , activeEmployees);
        List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
        model.addAttribute("inactiveEmployees" , inactiveEmployees);
        List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
        model.addAttribute("terminatedEmployees" , termminatedEmployees);
         // Redirect to the admin dashboard
        return "admin-dashboard";
    }
}