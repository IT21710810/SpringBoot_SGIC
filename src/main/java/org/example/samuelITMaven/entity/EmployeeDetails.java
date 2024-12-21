package org.example.samuelITMaven.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private String jobTitle;
    private String address;

    @JsonBackReference // Prevent recursion for Employee
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    public EmployeeDetails()
    {

    }

    // Default constructor for Hibernate
    public EmployeeDetails(long id, String department, String jobTitle, String address) {
    }

    // Constructor with parameters (optional)
    public EmployeeDetails(Long id, String department, String jobTitle, String address, Employee employee) {
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.address = address;
        this.employee = employee;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

