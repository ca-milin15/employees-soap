package com.moonshot.employee.employee.application.service;

import com.moonshot.employee.employee.application.dto.EmployeeFindActionRequest;
import com.moonshot.employee.employee.application.dto.EmployeeFindActionResponse;
import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;

public interface EmployeeService {
    
    EmployeeResponse addEmployee(EmployeeRequest employee);
    EmployeeFindActionResponse getEmployeeById(EmployeeFindActionRequest id);
}
