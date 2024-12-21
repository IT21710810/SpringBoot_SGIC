package org.example.samuelITMaven.service.implementation;

import org.example.samuelITMaven.entity.Designation;
import org.example.samuelITMaven.repository.DesignationRepository;
import org.example.samuelITMaven.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationServiceImpl implements DesignationService {
    @Autowired
    private DesignationRepository designationRepository;

    public Designation saveDesignation(Designation designation) {
        return designationRepository.save(designation);
    }
}
