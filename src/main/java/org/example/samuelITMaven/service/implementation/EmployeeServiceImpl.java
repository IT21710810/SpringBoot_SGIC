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
    public StandardResponse saveEmployee(EmployeeDTO employeeDTO) {
        logger.info("Starting saveEmployee with data: {}", employeeDTO);
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

            // Returning a StandardResponse with a success message and status
            return new StandardResponse(201, "Success", "Employee saved successfully.");
        } catch (Exception e) {
            logger.error("Error saving employee: {}", e.getMessage(), e);

            // Returning a StandardResponse with an error message and status
            return new StandardResponse(500, "Error", "Error saving employee.");
        }
    }


    @Override
    public StandardResponse getEmployeeById(long id) {
        logger.info("Fetching employee with ID: {}", id);
        try {
            return employeeRepository.findById(id)
                    .map(employee -> {
                        logger.info("Employee found: {}", employee);
                        EmployeeDTO employeeDTO = new EmployeeDTO(
                                employee.getId(),
                                employee.getFirst_Name(),
                                employee.getLast_name(),
                                employee.getEmail()
                        );
                        if (employee.getEmployeeDetails() != null) {
                            employeeDTO.setEmployeeDetails(new EmployeeDetailsSaveDTO(
                                    employee.getEmployeeDetails().getId(),
                                    employee.getEmployeeDetails().getDepartment(),
                                    employee.getEmployeeDetails().getJobTitle(),
                                    employee.getEmployeeDetails().getAddress()
                            ));
                        }
                        return new StandardResponse(200, "Success", employeeDTO);
                    })
                    .orElseGet(() -> {
                        logger.warn("Employee not found with ID: {}", id);
                        return new StandardResponse(404, "Not Found", "Employee not found with ID: " + id);
                    });
        } catch (Exception e) {
            logger.error("Error fetching employee: {}", e.getMessage(), e);
            return new StandardResponse(500, "Error", "Error fetching employee.");
        }
    }

    @Override
    public StandardResponse deleteEmployee(long id) {
        logger.info("Deleting employee with ID: {}", id);
        try {
            if (!employeeRepository.existsById(id)) {
                logger.warn("No employee found with ID: {}", id);
                return new StandardResponse(404, "Not Found", "No employee found with ID: " + id);
            }
            employeeRepository.deleteById(id);
            logger.info("Employee deleted successfully with ID: {}", id);
            return new StandardResponse(200, "Success", "Employee deleted successfully.");
        } catch (Exception e) {
            logger.error("Error deleting employee: {}", e.getMessage(), e);
            return new StandardResponse(500, "Error", "Error deleting employee.");
        }
    }


    @Override
    public StandardResponse updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
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
                        return new StandardResponse(200, "Success", "Employee updated successfully.");
                    })
                    .orElseGet(() -> {
                        logger.warn("No employee found with ID: {}", employeeUpdateDTO.getId());
                        return new StandardResponse(404, "Not Found", "No employee found with ID: " + employeeUpdateDTO.getId());
                    });
        } catch (Exception e) {
            logger.error("Error updating employee: {}", e.getMessage(), e);
            return new StandardResponse(500, "Error", "Error updating employee.");
        }
    }

    @Override
    public StandardResponse getAllEmployees() {
        logger.info("Fetching all employees.");
        try {
            List<Employee> employees = employeeRepository.findAll();
            if (employees.isEmpty()) {
                logger.warn("No employees found.");
                return new StandardResponse(404, "Not Found", "No employees found.");
            }

            List<EmployeeDTO> employeeDTOList = employees.stream().map(employee -> {
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        employee.getId(),
                        employee.getFirst_Name(),
                        employee.getLast_name(),
                        employee.getEmail()
                );

                // Check if EmployeeDetails exists and add it to EmployeeDTO
                if (employee.getEmployeeDetails() != null) {
                    employeeDTO.setEmployeeDetails(new EmployeeDetailsSaveDTO(
                            employee.getEmployeeDetails().getId(),
                            employee.getEmployeeDetails().getDepartment(),
                            employee.getEmployeeDetails().getJobTitle(),
                            employee.getEmployeeDetails().getAddress()
                    ));
                }

            logger.info("Fetched {} employees successfully.", employeeDTOList.size());
            return new StandardResponse(200, "Success", employeeDTOList);
        } catch (Exception e) {
            logger.error("Error fetching employees: {}", e.getMessage(), e);
            return new StandardResponse(500, "Error", "Error fetching employees.");
        }
    }

}
