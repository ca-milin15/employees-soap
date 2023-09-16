package com.moonshot.employee.employee.application.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.moonshot.employee.employee.application.dto.EmployeeDTO;
import com.moonshot.employee.employee.domain.Employee;
import com.moonshot.employee.employee.domain.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        var employee = employeeDTO.toEntity();
        return buildObjectResponse(employeeRepository.save(employee));
    }

    private EmployeeDTO buildObjectResponse(Employee save) {
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(BigInteger id) {
        var employeeAsEntity = employeeRepository.getReferenceById(id);
        return buildObjectResponse(employeeAsEntity);
    }
    
}
