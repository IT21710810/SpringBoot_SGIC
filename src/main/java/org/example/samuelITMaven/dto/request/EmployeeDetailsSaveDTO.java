package org.example.samuelITMaven.dto.request;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDetailsSaveDTO {
    private long id;
    private String department;
    private String jobTitle;
    private String address;

    public EmployeeDetailsSaveDTO(long id, String department, String jobTitle, String address) {
        this.id = id;
        this.department = department;
        this.jobTitle = jobTitle;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "EmployeeDetailsSaveDTO{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
