package com.moonshot.employee.shared.application.exception;

public class APIIntegrationErrorRuntimeException extends GeneralCustomRuntimeException {

    public APIIntegrationErrorRuntimeException(String message, ErrorDetailDTO errorDetailDTO) {
        super(message, errorDetailDTO);
    }
}
