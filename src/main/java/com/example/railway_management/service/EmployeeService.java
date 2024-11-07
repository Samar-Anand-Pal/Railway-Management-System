package com.example.railway_management.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.railway_management.repository.EmployeeRepository;
import com.example.railway_management.model.Employee;



@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Method to authenticate employee using employeeId and phoneNumber
    public boolean authenticate(int employeeId, String phoneNumber) {
        System.out.println("employee_servicee_entered");
        Employee employee = employeeRepository.findByEmployeeIdAndPhoneNumber(employeeId, phoneNumber);
        System.out.println("exit employee_service");
        return employee != null;
    }
    public Employee findAuthenticatedEmployee(String username) {
        System.out.println("employee_service_entered");
        Employee employee = employeeRepository.getEmployeeByIdAndPhoneNumber(username);
        System.out.println("exit employee_service");
        return employee;
    }

    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllActive(); // Assuming you have a method in repository to get all employees
    }

    public List<Employee> getAllInactiveEmployees() {
        return employeeRepository.findAllInactive(); // Assuming you have a method in repository to get all employees
    }

    public List<Employee> getAllTerminatedEmployees() {
        return employeeRepository.findAllTerminated(); // Assuming you have a method in repository to get all employees
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee); // Save the employee entity to the database
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee); // Save the employee entity to the database
    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId); // Call the repository to delete the employee
    }

    public void reactivateEmployee(int employeeId) {
        employeeRepository.reactivateEmployee(employeeId);
    }


}