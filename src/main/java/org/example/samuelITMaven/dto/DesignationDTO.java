package org.example.samuelITMaven.dto;

import java.util.List;

public class DesignationDTO {
    private Long designationId;

    private String designationName;

    private List<EmployeeDTO> employees;

    public DesignationDTO()
    {

    }

    public DesignationDTO(Long designationId, String designationName, List<EmployeeDTO> employees) {
        this.designationId = designationId;
        this.designationName = designationName;
        this.employees = employees;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
