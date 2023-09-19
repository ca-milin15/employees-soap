package com.moonshot.employee.shared.application.exception;

public class APIIntegrationRuntimeException extends RuntimeException {
    
    public APIIntegrationRuntimeException(String message) {
        super(message);
    }
}
