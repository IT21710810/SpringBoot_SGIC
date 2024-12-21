package org.example.samuelITMaven.dto;

import jakarta.transaction.Transactional;
import org.example.samuelITMaven.dto.request.EmployeeDetailsSaveDTO;

@Transactional
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private EmployeeDetailsSaveDTO employeeDetails;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


//    public EmployeeDTO(Long id, String firstName, String lastName, String email, EmployeeDetailsSaveDTO employeeDetails) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.employeeDetails = employeeDetails;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeDetailsSaveDTO getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsSaveDTO employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

//    public String getFirst_Name() {
//    }
//
//    public String getLast_name() {
//    }
}
