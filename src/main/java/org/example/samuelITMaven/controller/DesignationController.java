package org.example.samuelITMaven.controller;

import org.example.samuelITMaven.entity.Designation;
import org.example.samuelITMaven.service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/designations")
public class DesignationController {
    @Autowired
    private DesignationService designationService;

    @PostMapping("/save")
    public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation) {
        Designation savedDesignation = designationService.saveDesignation(designation);
        return ResponseEntity.ok(savedDesignation);
    }
}
