package com.moonshot.employee.employee.infrastructure;

import java.math.BigInteger;

import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.moonshot.employee.employee.application.dto.EmployeeDTO;
import com.moonshot.employee.employee.application.service.UserService;

import lombok.AllArgsConstructor;


@Endpoint
@AllArgsConstructor
public class UserEndpoint {

    UserService userService;

    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        return userService.addEmployee(employee);
    }

    public EmployeeDTO getEmployeeById(BigInteger id) {
        return userService.getEmployeeById(id);
    }
}