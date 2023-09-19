package com.moonshot.employee.employee.application.exceptions;

public class EmployeeNotFoundRuntimeException extends RuntimeException {
    
    public EmployeeNotFoundRuntimeException(String message) {
        super(message);
    }
}
