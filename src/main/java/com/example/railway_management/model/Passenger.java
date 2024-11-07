// package com.example.railway_management.model;

// import java.time.LocalDate;

// public class Passenger {

//     private int passengerId;                // Primary key
//     private int transactionId;               // Foreign key referencing PAYMENT table
//     private String firstName;                // First name
//     private String middleName;               // Middle name
//     private String lastName;                 // Last name
//     private String gender;                   // Gender (MALE, FEMALE, OTHER)
//     private LocalDate dateOfBirth;          // Date of birth
//     private String userName;                 // Username
//     private String password;                 // Password
//     private String typeOfId;                 // Type of ID (PASSPORT, AADHAAR, etc.)
//     private String idNumber;                 // ID number
//     private String phoneNumber;              // Phone number
//     private String email;                    // Email address
//     private String street;                   // Street address
//     private String city;                     // City
//     private String state;                    // State
//     private String zipCode;                  // Zip code
//     private String nationality;              // Nationality
//     private int ticketId;                    // Foreign key referencing TICKET table
//     private int trainId;                     // Foreign key referencing TRAIN table

//     // Getters and Setters
//     public int getPassengerId() {
//         return passengerId;
//     }

//     public void setPassengerId(int passengerId) {
//         this.passengerId = passengerId;
//     }

//     public int getTransactionId() {
//         return transactionId;
//     }

//     public void setTransactionId(int transactionId) {
//         this.transactionId = transactionId;
//     }

//     public String getFirstName() {
//         return firstName;
//     }

//     public void setFirstName(String firstName) {
//         this.firstName = firstName;
//     }

//     public String getMiddleName() {
//         return middleName;
//     }

//     public void setMiddleName(String middleName) {
//         this.middleName = middleName;
//     }

//     public String getLastName() {
//         return lastName;
//     }

//     public void setLastName(String lastName) {
//         this.lastName = lastName;
//     }

//     public String getGender() {
//         return gender;
//     }

//     public void setGender(String gender) {
//         this.gender = gender;
//     }

//     public LocalDate getDateOfBirth() {
//         return dateOfBirth;
//     }

//     public void setDateOfBirth(LocalDate dateOfBirth) {
//         this.dateOfBirth = dateOfBirth;
//     }

//     public String getUserName() {
//         return userName;
//     }

//     public void setUserName(String userName) {
//         this.userName = userName;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     public String getTypeOfId() {
//         return typeOfId;
//     }

//     public void setTypeOfId(String typeOfId) {
//         this.typeOfId = typeOfId;
//     }

//     public String getIdNumber() {
//         return idNumber;
//     }

//     public void setIdNumber(String idNumber) {
//         this.idNumber = idNumber;
//     }

//     public String getPhoneNumber() {
//         return phoneNumber;
//     }

//     public void setPhoneNumber(String phoneNumber) {
//         this.phoneNumber = phoneNumber;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getStreet() {
//         return street;
//     }

//     public void setStreet(String street) {
//         this.street = street;
//     }

//     public String getCity() {
//         return city;
//     }

//     public void setCity(String city) {
//         this.city = city;
//     }

//     public String getState() {
//         return state;
//     }

//     public void setState(String state) {
//         this.state = state;
//     }

//     public String getZipCode() {
//         return zipCode;
//     }

//     public void setZipCode(String zipCode) {
//         this.zipCode = zipCode;
//     }

//     public String getNationality() {
//         return nationality;
//     }

//     public void setNationality(String nationality) {
//         this.nationality = nationality;
//     }

//     public int getTicketId() {
//         return ticketId;
//     }

//     public void setTicketId(int ticketId) {
//         this.ticketId = ticketId;
//     }

//     public int getTrainId() {
//         return trainId;
//     }

//     public void setTrainId(int trainId) {
//         this.trainId = trainId;
//     }
// }
package com.example.railway_management.model;

public class Passenger {

    private int passengerId;              // Primary key
    private String firstName;             // First name with default 'Unknown'
    private String middleName;            // Middle name, nullable
    private String lastName;              // Last name with default 'Unknown'
    private String gender;                // ENUM ('MALE', 'FEMALE', 'OTHER') with default 'OTHER'
    private int ticketId;                 // Foreign key referencing TICKET table
    private int age;                      // Age, must be greater than 0
    private int coachNo;                  // Foreign key referencing COACH table
    private int seatNo;                   // Seat number in the coach
                     // Day of journey (ENUM for days of the week)

    // Getters and Setters
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(int coachNo) {
        this.coachNo = coachNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", ticketId=" + ticketId +
                ", age=" + age +
                ", coachNo=" + coachNo +
                ", seatNo=" + seatNo +
                '}';
    }
}
