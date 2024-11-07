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
// import com.example.railway_management.service.EmployeeService;
// import org.springframework.ui.Model;

// @Controller
// public class AddEmployeeController {

//     @Autowired
//     private EmployeeService employeeService; // Assuming you have a service for business logic

//     @PostMapping("/add-employee")
//     public String addEmployee(
//         @RequestParam("firstName") String firstName,
//         @RequestParam(value = "middleName", required = false) String middleName,
//         @RequestParam("lastName") String lastName,
//         @RequestParam("gender") String gender,
//         @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
//         @RequestParam("department") String department,
//         @RequestParam("phoneNo") String phoneNo,
//         @RequestParam("email") String email,
//         @RequestParam("dateOfJoining") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfJoining,
//         @RequestParam("workplace") String workplace,
//         @RequestParam("street") String street,
//         @RequestParam("city") String city,
//         @RequestParam("state") String state,
//         @RequestParam("zipCode") String zipCode,
//         @RequestParam(value = "trainId") Integer trainId, // Nullable field
//         @RequestParam(value = "stationId") Integer stationId, // Nullable field
//         @RequestParam("employmentStatus") String employmentStatus, // New field
//         Model model) {
        
//         // Create a new Employee object and set its properties
//         Employee employee = new Employee();
//         employee.setFirstName(firstName);
//         employee.setMiddleName(middleName);
//         employee.setLastName(lastName);
//         employee.setGender(gender);
//         employee.setDob(dob); // Convert to appropriate date format if necessary
//         employee.setDepartment(department);
//         employee.setPhoneNo(phoneNo);
//         employee.setEmail(email);
//         employee.setDateOfJoining(dateOfJoining); // Convert as necessary
//         employee.setWorkplace(workplace);
//         employee.setStreet(street);
//         employee.setCity(city);
//         employee.setState(state);
//         employee.setZipCode(zipCode);
//         employee.setTrainId(trainId);
//         employee.setStationId(stationId);
//         employee.setEmploymentStatus(employmentStatus);

//         // Save the employee using the service
//         employeeService.saveEmployee(employee);

//         // Add a success message or redirect to the employee list page
//         model.addAttribute("successMessage", "Employee added successfully!");
//         List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
//             model.addAttribute("activeEmployees" , activeEmployees);
//             List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
//             model.addAttribute("inactiveEmployees" , inactiveEmployees);
//             List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
//             model.addAttribute("terminatedEmployees" , termminatedEmployees);
//         return "admin-dashboard"; // Adjust this according to your route for employee list
//     }

//      @PostMapping("/reactivate-employee/{id}")
//     public String reactivateEmployee(@PathVariable("id") Long employeeId, Model model) {
//         employeeService.reactivateEmployee(employeeId);
//         model.addAttribute("successMessage", "Employee added successfully!");
//         List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
//             model.addAttribute("activeEmployees" , activeEmployees);
//             List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
//             model.addAttribute("inactiveEmployees" , inactiveEmployees);
//             List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
//             model.addAttribute("terminatedEmployees" , termminatedEmployees);
//         return "admin-dashboard"; // Adjust this according to your route for employee list
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
import com.example.railway_management.service.EmployeeService;
// import org.springframework.ui.Model;
import com.example.railway_management.model.Users;
import com.example.railway_management.service.UserService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class AddEmployeeController {

    @Autowired
    private EmployeeService employeeService; // Assuming you have a service for business logic

    @Autowired
    private UserService userService;

   
    
    @GetMapping("/add-employee")
    public String addingEmployee(){
       
        return "employee-register";
    }

    @PostMapping("/add-employee")
    public String postaddEmployee(
        @RequestParam("firstName") String firstName,
        @RequestParam(value = "middleName", required = false) String middleName,
        @RequestParam("lastName") String lastName,
        @RequestParam("gender") String gender,
        @RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob,
        @RequestParam("department") String department,
        @RequestParam("phoneNo") String phoneNo,
        @RequestParam("email") String email,
        @RequestParam("dateOfJoining") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfJoining,
        @RequestParam("username") String username,
        @RequestParam("zipCode") String zipCode,
        @RequestParam(value = "trainId") Integer trainId, // Nullable field
        @RequestParam(value = "stationId") Integer stationId, // Nullable field
        @RequestParam("employmentStatus") String employmentStatus, // New field
        Model model) {
        
        // Create a new Employee object and set its properties
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setMiddleName(middleName);
        employee.setLastName(lastName);
        employee.setGender(gender);
        employee.setDob(dob); // Convert to appropriate date format if necessary
        employee.setDepartment(department);
        employee.setPhoneNo(phoneNo);
        employee.setEmail(email);
        employee.setDateOfJoining(dateOfJoining); // Convert as necessary
        employee.setUsername(username);
        employee.setZipCode(zipCode);
        employee.setTrainId(trainId);
        employee.setStationId(stationId);
        employee.setEmploymentStatus(employmentStatus);

        // Save the employee using the service
        employeeService.saveEmployee(employee);

        // Add a success message or redirect to the employee list page
        model.addAttribute("successMessage", "Employee added successfully!");
        List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
            model.addAttribute("activeEmployees" , activeEmployees);
            List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
            model.addAttribute("inactiveEmployees" , inactiveEmployees);
            List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
            model.addAttribute("terminatedEmployees" , termminatedEmployees);
        return "admin-dashboard"; // Adjust this according to your route for employee list
    }

    
    @PostMapping("/registerEmployee")
    public String registeruEmployee(@ModelAttribute Users user,Model model){

        try{
            user.setRole("employee");
            userService.register(user);
            System.out.println("sfsf"+user.getRole());
            model.addAttribute("usern",user.getUsername());
            return "add-employee";
        } catch (Exception e) {
            
            return "employee-register"; // Redirect back to the registration page
        }
       
    }


     @PostMapping("/reactivate-employee/{id}")
    public String reactivateEmployee(@PathVariable("id") int employeeId, Model model) {
        employeeService.reactivateEmployee(employeeId);
        model.addAttribute("successMessage", "Employee added successfully!");
        List<Employee> activeEmployees =  employeeService.getAllActiveEmployees();
            model.addAttribute("activeEmployees" , activeEmployees);
            List<Employee> inactiveEmployees =  employeeService.getAllInactiveEmployees();
            model.addAttribute("inactiveEmployees" , inactiveEmployees);
            List<Employee> termminatedEmployees =  employeeService.getAllTerminatedEmployees();
            model.addAttribute("terminatedEmployees" , termminatedEmployees);
        return "admin-dashboard"; // Adjust this according to your route for employee list
    }




}