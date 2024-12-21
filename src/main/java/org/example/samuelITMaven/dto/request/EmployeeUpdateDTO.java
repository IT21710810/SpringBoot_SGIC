package org.example.samuelITMaven.dto.request;

import jakarta.transaction.Transactional;


public class EmployeeUpdateDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private EmployeeDetailsUpdateDTO employeeDetails;

    public EmployeeUpdateDTO() {}

    public EmployeeUpdateDTO(Long id, String firstName, String lastName, String email, EmployeeDetailsUpdateDTO employeeDetails) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.employeeDetails = employeeDetails;
    }

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

    public EmployeeDetailsUpdateDTO getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsUpdateDTO employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    @Override
    public String toString() {
        return "EmployeeUpdateDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
