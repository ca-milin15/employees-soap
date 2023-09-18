package com.moonshot.employee.employee.application.service;

import java.math.BigInteger;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;
import com.moonshot.employee.employee.application.exceptions.DataIntegrityRuntimeException;
import com.moonshot.employee.employee.domain.Employee;
import com.moonshot.employee.employee.domain.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeDTO) {
        var employee = employeeDTO.toEntity();
        return buildObjectResponse(persistOnDB(employee));
    }

    private Employee persistOnDB(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityRuntimeException(e.getMessage());
        }
    }

    private EmployeeResponse buildObjectResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .status("OK")
                .build();
    }

    @Override
    public EmployeeResponse getEmployeeById(BigInteger id) {
        var employeeAsEntity = employeeRepository.getReferenceById(id);
        return buildObjectResponse(employeeAsEntity);
    }
    
}
