package com.moonshot.employee.employee.application.exceptions;

public class DataIntegrityRuntimeException extends RuntimeException {
    
    public DataIntegrityRuntimeException(String message) {
        super(message);
    }
}
