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
        return new ResponseEntity<>(
                response,
                HttpStatus.valueOf(response.getStatusCode())
        );
    }
//http://localhost:8080/get-by-id?id=5
    @GetMapping("/get-by-id")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@RequestParam long id) {
        EmployeeDTO employeeDTO = employeeService.getId(id);
        return ResponseEntity.ok(employeeDTO);
    }

//    http://localhost:8080/delete-employee/5
    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
        String message = employeeService.updateEmployee(employeeUpdateDTO);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }
}
