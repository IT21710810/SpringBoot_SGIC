package org.example.samuelITMaven.service;

import org.example.samuelITMaven.dto.request.EmployeeDetailsSaveDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeDetailsService {
    public String saveEmployeeDetails(EmployeeDetailsSaveDTO employeeDetailsDTO);
}
