package com.moonshot.employee.employee.application.service;

import java.math.BigInteger;

import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;

public interface EmployeeService {
    
    EmployeeResponse addEmployee(EmployeeRequest employee);
    EmployeeResponse getEmployeeById(BigInteger id);
}
