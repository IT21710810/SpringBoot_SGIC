package org.example.samuelITMaven.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String designationName;

    @JsonManagedReference // Allow serialization of employees
    @OneToMany(mappedBy = "designation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;


    public Designation() {}

    public Designation(String designationName, List<Employee> employees) {
        this.designationName = designationName;
        this.employees = employees;
        for (Employee employee : employees) {
            employee.setDesignation(this); // Maintain bidirectional relationship
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        for (Employee employee : employees) {
            employee.setDesignation(this);
        }
    }
}
