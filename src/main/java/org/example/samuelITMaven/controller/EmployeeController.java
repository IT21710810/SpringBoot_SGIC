package org.example.samuelITMaven.controller;

import org.example.samuelITMaven.dto.EmployeeDTO;
import org.example.samuelITMaven.dto.request.EmployeeUpdateDTO;
import org.example.samuelITMaven.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        StandardResponse response = employeeService.saveEmployee(employeeDTO);
        return createResponseEntity(response);
    }


    // http://localhost:8080/api/v1/employee/get-by-id?id=5
    @GetMapping("/get-by-id")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@RequestParam long id) {
        EmployeeDTO employeeDTO = employeeService.getId(id);
        return ResponseEntity.ok(employeeDTO);
    }

//    http://localhost:8080/delete-employee/5
    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<StandardResponse> deleteEmployee(@PathVariable long id) {
        StandardResponse response = employeeService.deleteEmployee(id);
        return createResponseEntity(response);
    }

    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        StandardResponse response = employeeService.updateEmployee(employeeUpdateDTO);
        return createResponseEntity(response);
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse> getAllEmployees() {
        StandardResponse response = employeeService.getAllEmployees();
        return createResponseEntity(response);
    }

    private ResponseEntity<StandardResponse> createResponseEntity(StandardResponse response) {
        return new ResponseEntity<>(
                response,
                HttpStatus.valueOf(response.getStatusCode())
        );
    }
}
