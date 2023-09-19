package com.moonshot.employee.employee.infrastructure;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.moonshot.employee.employee.application.dto.EmployeeFindActionRequest;
import com.moonshot.employee.employee.application.dto.EmployeeFindActionResponse;
import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;
import com.moonshot.employee.employee.application.service.EmployeeService;
import com.moonshot.employee.utility.Utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;


@Endpoint
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class EmployeeEndpoint {

    EmployeeService userService;

    @PayloadRoot(namespace = Utilities.NAME_SPACE, localPart = "EmployeeRequest")
    @ResponsePayload
    public EmployeeResponse addEmployee(@RequestPayload EmployeeRequest employee) {
        return userService.addEmployee(employee);
    }

    @PayloadRoot(namespace = Utilities.NAME_SPACE, localPart = "EmployeeFindActionRequest")
    @ResponsePayload
    public EmployeeFindActionResponse getEmployeeById(@RequestPayload EmployeeFindActionRequest employeeFindActionRequest) {
        return userService.getEmployeeById(employeeFindActionRequest);
    }
}