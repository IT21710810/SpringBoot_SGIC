package org.example.samuelITMaven.service;

import org.example.samuelITMaven.dto.EmployeeDTO;
import org.example.samuelITMaven.dto.request.EmployeeUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    StandardResponse saveEmployee(EmployeeDTO employeeDTO);

    StandardResponse getEmployeeById(long id);

    StandardResponse deleteEmployee(long id);

    StandardResponse updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    StandardResponse getAllEmployees(); // This method fetches all employees
}
