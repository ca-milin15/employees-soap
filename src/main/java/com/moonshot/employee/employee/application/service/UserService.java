package com.moonshot.employee.employee.application.service;

import java.math.BigInteger;

import com.moonshot.employee.employee.application.dto.EmployeeDTO;

public interface UserService {
    
    EmployeeDTO addEmployee(EmployeeDTO employee);
    EmployeeDTO getEmployeeById(BigInteger id);
}
