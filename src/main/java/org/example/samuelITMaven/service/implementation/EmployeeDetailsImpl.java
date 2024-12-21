package org.example.samuelITMaven.service.implementation;

import org.example.samuelITMaven.dto.request.EmployeeDetailsSaveDTO;
import org.example.samuelITMaven.entity.EmployeeDetails;
import org.example.samuelITMaven.repository.EmployeeDetailsRepo;
import org.example.samuelITMaven.service.EmployeeDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsImpl implements EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepo employeeDetailsRepo;

    @Override
    public String saveEmployeeDetails(EmployeeDetailsSaveDTO employeeDetailsSaveDTO) {
//        EmployeeDetails employeeDetails = new EmployeeDetails(
//                employeeDetailsSaveDTO.getId(),
//                employeeDetailsSaveDTO.getDepartment(),
//                employeeDetailsSaveDTO.getJobTitle(),
//                employeeDetailsSaveDTO.getAddress()
//        );
//        employeeDetailsRepo.save(employeeDetails);
        return "saved employee details successfully";
    }
}
