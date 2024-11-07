// package com.example.railway_management.repository;

// import com.example.railway_management.model.Passenger;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.BatchPreparedStatementSetter;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.stereotype.Repository;

// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.sql.Date; // Import java.sql.Date for type conversion
// import java.util.List;

// @Repository
// public class PassengerRepository {

//     @Autowired
//     private JdbcTemplate jdbcTemplate;

//     // Method to save a single passenger
//     public void save(Passenger passenger) {
        
//         String sql = "INSERT INTO PASSENGER (F_NAME, M_NAME, L_NAME, GENDER, DOB, USER_NAME, PASSWORD, TYPE_OF_ID, ID_NUMBER, PHONE_NUMBER, EMAIL, STREET, CITY, STATE, ZIP_CODE, NATIONALITY, TICKET_ID, TRAIN_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//         jdbcTemplate.update(sql,
//             passenger.getFirstName(),
//             passenger.getMiddleName(),
//             passenger.getLastName(),
//             passenger.getGender(),
//             Date.valueOf(passenger.getDateOfBirth()), // Convert LocalDate to java.sql.Date
//             passenger.getUserName(),
//             passenger.getPassword(),
//             passenger.getTypeOfId(),
//             passenger.getIdNumber(),
//             passenger.getPhoneNumber(),
//             passenger.getEmail(),
//             passenger.getStreet(),
//             passenger.getCity(),
//             passenger.getState(),
//             passenger.getZipCode(),
//             passenger.getNationality(),
//             passenger.getTicketId(),
//             passenger.getTrainId()
//         );
//     }

//     // Method to save multiple passengers using batch updates
//     public void saveAll(List<Passenger> passengers) {
//         System.out.println("Entered from passenger repository");
//         String sql = "INSERT INTO PASSENGER (F_NAME, M_NAME, L_NAME, GENDER, DOB, USER_NAME, PASSWORD, TYPE_OF_ID, ID_NUMBER, PHONE_NUMBER, EMAIL, STREET, CITY, STATE, ZIP_CODE, NATIONALITY, TICKET_ID, TRAIN_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//         jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//             @Override
//             public void setValues(PreparedStatement ps, int i) throws SQLException {
//                 Passenger passenger = passengers.get(i);
//                 ps.setString(1, passenger.getFirstName());
//                 ps.setString(2, passenger.getMiddleName());
//                 ps.setString(3, passenger.getLastName());
//                 ps.setString(4, passenger.getGender());
//                 ps.setDate(5, Date.valueOf(passenger.getDateOfBirth())); // Convert LocalDate to java.sql.Date
//                 ps.setString(6, passenger.getUserName());
//                 ps.setString(7, passenger.getPassword());
//                 ps.setString(8, passenger.getTypeOfId());
//                 ps.setString(9, passenger.getIdNumber());
//                 ps.setString(10, passenger.getPhoneNumber());
//                 ps.setString(11, passenger.getEmail());
//                 ps.setString(12, passenger.getStreet());
//                 ps.setString(13, passenger.getCity());
//                 ps.setString(14, passenger.getState());
//                 ps.setString(15, passenger.getZipCode());
//                 ps.setString(16, passenger.getNationality());
//                 ps.setInt(17, passenger.getTicketId());
//                 ps.setInt(18, passenger.getTrainId());
//             }
//             @Override
//             public int getBatchSize() {
//                 return passengers.size();
//             }
//         });
//         System.out.println("exited from passenger repository");
//     }

//     // Additional methods can be added here (e.g., findById, findAll, delete, etc.)
// }


package com.example.railway_management.repository;

import com.example.railway_management.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PassengerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to save a single passenger
    public void save(Passenger passenger) {
        String sql = "INSERT INTO PASSENGER (F_NAME, M_NAME, L_NAME, GENDER, TICKET_ID, AGE, COACH_NO, SEAT_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
            passenger.getFirstName(),
            passenger.getMiddleName(),
            passenger.getLastName(),
            passenger.getGender(),
            
            passenger.getTicketId(),
            passenger.getAge(),
           
            passenger.getCoachNo(),
            passenger.getSeatNo()
            
        );
    }

    // Method to save multiple passengers using batch updates
    public void saveAll(List<Passenger> passengers) {
        String sql = "INSERT INTO PASSENGER (F_NAME, M_NAME, L_NAME, GENDER,  TICKET_ID, AGE,  COACH_NO, SEAT_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Passenger passenger = passengers.get(i);
                ps.setString(1, passenger.getFirstName());
                ps.setString(2, passenger.getMiddleName());
                ps.setString(3, passenger.getLastName());
                ps.setString(4, passenger.getGender());
                ps.setInt(5, passenger.getTicketId());
                ps.setInt(6, passenger.getAge());
                ps.setInt(7, passenger.getCoachNo());
                ps.setInt(8, passenger.getSeatNo());
        
            }
            @Override
            public int getBatchSize() {
                return passengers.size();
            }
        });
    }

    // Additional methods can be added here (e.g., findById, findAll, delete, etc.)
}
