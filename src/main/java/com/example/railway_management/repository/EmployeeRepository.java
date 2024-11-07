package com.example.railway_management.repository;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.railway_management.model.Employee;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Custom query to find employee by employee_id and phone_number
    public Employee findByEmployeeIdAndPhoneNumber(int employeeId, String phoneNumber) {
        String sql = "SELECT employee_id, phone_no, username FROM employee WHERE employee_id = ? AND phone_no = ?";
        try {
            System.out.println("entered repository -- findByEmployeeIdAndPhoneNumber");
            return jdbcTemplate.queryForObject(sql, new Object[]{employeeId, phoneNumber}, new EmployeeRowMapper());
        } catch (Exception e) {
            // Handle case where no employee is found
            return null;
        }
    }

    // Method to get all details of employee by employeeId and phoneNumber
    public Employee getEmployeeByIdAndPhoneNumber( String username) {
        String sql = "SELECT * FROM employee WHERE username= ?";
        try {
            System.out.println("entered repository -- getEmployeeByIdAndPhoneNumber");
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, new EmployeeFullDetailsRowMapper());
        } catch (Exception e) {
            // Handle case where no employee is found
            return null;
        }
    }

    // RowMapper for mapping limited employee fields (for basic authentication)
    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("entered employee row mapper");
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setPhoneNo(rs.getString("phone_no"));
            employee.setUsername(rs.getString("username"));  // Map username
            System.out.println("exited employee row mapper");
            return employee;
        }
    }

    // RowMapper for mapping all employee fields (full details)
    private static class EmployeeFullDetailsRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            System.out.println("entered employee full details row mapper");
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setTrainId(rs.getObject("train_id") != null ? rs.getInt("train_id") : null);
            employee.setStationId(rs.getObject("station_id") != null ? rs.getInt("station_id") : null);
            employee.setFirstName(rs.getString("f_name"));
            employee.setMiddleName(rs.getString("m_name"));
            employee.setLastName(rs.getString("l_name"));
            employee.setGender(rs.getString("gender"));
            employee.setDob(rs.getDate("dob"));
            employee.setDepartment(rs.getString("department"));
            employee.setPhoneNo(rs.getString("phone_no"));
            employee.setEmail(rs.getString("email"));
            employee.setDateOfJoining(rs.getDate("date_of_joining"));
            employee.setEmploymentStatus(rs.getString("employment_status"));
            employee.setUsername(rs.getString("username"));  // Map username
            employee.setZipCode(rs.getString("pin_code"));
            System.out.println("exited employee full details row mapper");
            return employee;
        }
    }

    public List<Employee> findAllActive() {
        String sql = "SELECT * FROM employee WHERE EMPLOYMENT_STATUS = 'ACTIVE' ";
        return jdbcTemplate.query(sql, new EmployeeRowMapper1());
    }

    private static class EmployeeRowMapper1 implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setTrainId(rs.getObject("train_id") != null ? rs.getInt("train_id") : null);
            employee.setStationId(rs.getObject("station_id") != null ? rs.getInt("station_id") : null);
            employee.setFirstName(rs.getString("f_name"));
            employee.setMiddleName(rs.getString("m_name"));
            employee.setLastName(rs.getString("l_name"));
            employee.setPhoneNo(rs.getString("phone_no"));
            employee.setEmail(rs.getString("email"));
            employee.setUsername(rs.getString("username"));  // Map username
            return employee;
        }
    }

    public List<Employee> findAllInactive() {
        String sql = "SELECT * FROM employee WHERE EMPLOYMENT_STATUS = 'INACTIVE'";
        return jdbcTemplate.query(sql, new EmployeeRowMapper2());
    }

    private static class EmployeeRowMapper2 implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setTrainId(rs.getObject("train_id") != null ? rs.getInt("train_id") : null);
            employee.setStationId(rs.getObject("station_id") != null ? rs.getInt("station_id") : null);
            employee.setFirstName(rs.getString("f_name"));
            employee.setMiddleName(rs.getString("m_name"));
            employee.setLastName(rs.getString("l_name"));
            employee.setPhoneNo(rs.getString("phone_no"));
            employee.setEmail(rs.getString("email"));
            employee.setUsername(rs.getString("username"));  // Map username
            return employee;
        }
    }

    public List<Employee> findAllTerminated() {
        String sql = "SELECT * FROM employee WHERE EMPLOYMENT_STATUS = 'TERMINATED'";
        return jdbcTemplate.query(sql, new EmployeeRowMapper3());
    }

    private static class EmployeeRowMapper3 implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setTrainId(rs.getObject("train_id") != null ? rs.getInt("train_id") : null);
            employee.setStationId(rs.getObject("station_id") != null ? rs.getInt("station_id") : null);
            employee.setFirstName(rs.getString("f_name"));
            employee.setMiddleName(rs.getString("m_name"));
            employee.setLastName(rs.getString("l_name"));
            employee.setPhoneNo(rs.getString("phone_no"));
            employee.setEmail(rs.getString("email"));
            employee.setUsername(rs.getString("username"));  // Map username
            return employee;
        }
    }

    public void save(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE (TRAIN_ID, STATION_ID, F_NAME, M_NAME, L_NAME, GENDER, DOB, " +
                "DEPARTMENT, PHONE_NO, EMAIL, DATE_OF_JOINING, EMPLOYMENT_STATUS, USERNAME) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                employee.getTrainId(),
                employee.getStationId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getDob(),
                employee.getDepartment(),
                employee.getPhoneNo(),
                employee.getEmail(),
                employee.getDateOfJoining(),
                employee.getEmploymentStatus(),
                employee.getUsername());  // Include username
    }

    public void update(Employee employee) {
        String sql = "UPDATE EMPLOYEE SET " +
        "TRAIN_ID = ?, " +
        "STATION_ID = ?, " +
        "F_NAME = ?, " +
        "M_NAME = ?, " +
        "L_NAME = ?, " +
        "GENDER = ?, " +
        "DOB = ?, " +
        "DEPARTMENT = ?, " +
        "PHONE_NO = ?, " +
        "EMAIL = ?, " +
        "DATE_OF_JOINING = ?, " +
        "EMPLOYMENT_STATUS = ? " +
        "WHERE USERNAME = ?";  // Assuming 'USERNAME' is used as the unique identifier for the employee

        jdbcTemplate.update(sql,
                employee.getTrainId(),
                employee.getStationId(),
                employee.getFirstName(),
                employee.getMiddleName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getDob(),
                employee.getDepartment(),
                employee.getPhoneNo(),
                employee.getEmail(),
                employee.getDateOfJoining(),
                employee.getEmploymentStatus(),
                employee.getUsername());  // Include username
    }

    public void deleteById(int employeeId) {
        String sql = "UPDATE EMPLOYEE SET EMPLOYMENT_STATUS = 'TERMINATED' WHERE EMPLOYEE_ID = ?";
        jdbcTemplate.update(sql, employeeId);
    }

    public void reactivateEmployee(int employeeId) {  // Change Long to int
        String sql = "UPDATE EMPLOYEE SET EMPLOYMENT_STATUS = 'ACTIVE' WHERE EMPLOYEE_ID = ?";
        jdbcTemplate.update(sql, employeeId);
    }
}