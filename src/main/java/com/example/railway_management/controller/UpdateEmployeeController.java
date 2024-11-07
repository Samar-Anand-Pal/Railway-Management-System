package com.example.railway_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.railway_management.service.EmployeeService;
import com.example.railway_management.model.Employee;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.railway_management.service.UserService;

import java.util.Date;
import java.util.List;

@Controller
public class UpdateEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;
    

@GetMapping("/update-employee/{username}")
public String getupdateuEmployee(@PathVariable("username") String username,Model model){
    Employee emp=employeeService.findAuthenticatedEmployee(username);
     model.addAttribute("usern",username);
     model.addAttribute("emp",emp);
     System.out.println("ggs"+emp.getZipCode());
    return "update-employee";
}

@PostMapping("/update-employee")
public String postupdateEmployee(
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
    employeeService.updateEmployee(employee);

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

}