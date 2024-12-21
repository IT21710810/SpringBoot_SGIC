package org.example.samuelITMaven.service;

import org.example.samuelITMaven.dto.EmployeeDTO;
import org.example.samuelITMaven.dto.request.EmployeeUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public String saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getId(long id);

    void deleteEmployee(long id);

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    List<EmployeeDTO> getAllEmployee();
}
