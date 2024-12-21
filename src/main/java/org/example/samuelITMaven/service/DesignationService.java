package org.example.samuelITMaven.service;

import org.example.samuelITMaven.dto.DesignationDTO;
import org.example.samuelITMaven.dto.EmployeeDTO;
import org.example.samuelITMaven.entity.Designation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DesignationService {

    Designation saveDesignation(Designation designation);
}
