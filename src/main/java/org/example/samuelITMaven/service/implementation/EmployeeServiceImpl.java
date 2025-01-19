package org.example.samuelITMaven.service.implementation;

import jakarta.transaction.Transactional;
import org.example.samuelITMaven.dto.EmployeeDTO;
import org.example.samuelITMaven.dto.request.EmployeeDetailsSaveDTO;
import org.example.samuelITMaven.dto.request.EmployeeDetailsUpdateDTO;
import org.example.samuelITMaven.dto.request.EmployeeUpdateDTO;
import org.example.samuelITMaven.entity.Employee;
import org.example.samuelITMaven.entity.EmployeeDetails;
import org.example.samuelITMaven.repository.EmployeeRepository;
import org.example.samuelITMaven.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(EmployeeDTO employeeDTO) {
        try {
            logger.info("Attempting to save employee:");

            // Create the employee and employee details
            Employee employee = new Employee(
                    employeeDTO.getId(),
                    employeeDTO.getFirstName(),
                    employeeDTO.getLastName(),
                    employeeDTO.getEmail()
            );

            if (employeeDTO.getEmployeeDetails() != null) {
                EmployeeDetails details = new EmployeeDetails(
                        employeeDTO.getEmployeeDetails().getId(),
                        employeeDTO.getEmployeeDetails().getDepartment(),
                        employeeDTO.getEmployeeDetails().getJobTitle(),
                        employeeDTO.getEmployeeDetails().getAddress(),
                        employee
                );
                employee.setEmployeeDetails(details);
            }

            // Set employeeDetails to employee
            employee.setEmployeeDetails(employeeDetails);

            // Save the employee and its details
            employeeRepository.save(employee);
            logger.info("Employee saved successfully: {}", employee);
            return "Employee saved successfully.";
        } catch (Exception e) {
            logger.error("Error saving employee: {}", e.getMessage(), e);
            return "Error saving employee.";
        }
    }


    @Override
    public EmployeeDTO getId(long id) {
        return employeeRepository.findById(id).map(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    employee.getId(),
                    employee.getFirst_Name(),
                    employee.getLast_name(),
                    employee.getEmail()
            );
            if (employee.getEmployeeDetails() != null) {
                EmployeeDetailsSaveDTO detailsDTO = new EmployeeDetailsSaveDTO(
                        employee.getEmployeeDetails().getId(),
                        employee.getEmployeeDetails().getDepartment(),
                        employee.getEmployeeDetails().getJobTitle(),
                        employee.getEmployeeDetails().getAddress()
                );
                employeeDTO.setEmployeeDetails(detailsDTO);
            }
            return employeeDTO;
        }).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }


    @Override
    public void deleteEmployee(long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("No employee found with ID: " + id);
        }
    }


    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        logger.info("Updating employee with ID: {}", employeeUpdateDTO.getId());
        return employeeRepository.findById(employeeUpdateDTO.getId())
                .map(employee -> {
                    logger.info("Employee found for update: {}", employee);
                    employee.setFirst_Name(employeeUpdateDTO.getFirstName());
                    employee.setLast_name(employeeUpdateDTO.getLastName());
                    employee.setEmail(employeeUpdateDTO.getEmail());

                    if (employeeUpdateDTO.getEmployeeDetails() != null) {
                        EmployeeDetails details = Optional.ofNullable(employee.getEmployeeDetails())
                                .orElse(new EmployeeDetails());
                        details.setDepartment(employeeUpdateDTO.getEmployeeDetails().getDepartment());
                        details.setJobTitle(employeeUpdateDTO.getEmployeeDetails().getJobTitle());
                        details.setAddress(employeeUpdateDTO.getEmployeeDetails().getAddress());
                        details.setEmployee(employee);
                        employee.setEmployeeDetails(details);
                    }

                    employeeRepository.save(employee);
                    logger.info("Employee updated successfully: {}", employee);
                    return "Employee updated successfully.";
                })
                .orElseThrow(() -> {
                    logger.warn("No employee found with ID: {}", employeeUpdateDTO.getId());
                    return new RuntimeException("No employee found with ID: " + employeeUpdateDTO.getId());
                });
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        logger.info("Fetching all employees.");
        try {
            List<Employee> employees = employeeRepository.findAll();
            if (employees.isEmpty()) {
                logger.warn("No employees found.");
                throw new RuntimeException("No employees found.");
            }

            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            for (Employee employee : getAllEmployee) {
                // Build EmployeeDTO with EmployeeDetails
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        employee.getId(),
                        employee.getFirst_Name(),
                        employee.getLast_name(),
                        employee.getEmail()
                );

                // Check if EmployeeDetails exists and add it to EmployeeDTO
                if (employee.getEmployeeDetails() != null) {
                    EmployeeDetailsSaveDTO detailsDTO = new EmployeeDetailsSaveDTO(
                            employee.getEmployeeDetails().getId(),
                            employee.getEmployeeDetails().getDepartment(),
                            employee.getEmployeeDetails().getJobTitle(),
                            employee.getEmployeeDetails().getAddress()
                    );
                    employeeDTO.setEmployeeDetails(detailsDTO);
                }

                logger.info("Employees fetched successfully.");
                employeeDTOList.add(employeeDTO);
            }
            return employeeDTOList;
        } catch (Exception e) {
            logger.error("Error fetching all employees:", e);
            throw new RuntimeException("Error fetching all employees");
        }
    }

}
