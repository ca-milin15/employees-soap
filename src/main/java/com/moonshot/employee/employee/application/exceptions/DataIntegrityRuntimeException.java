package com.moonshot.employee.employee.application.exceptions;

import com.moonshot.employee.shared.application.exception.ErrorDetailDTO;
import com.moonshot.employee.shared.application.exception.GeneralCustomRuntimeException;

public class DataIntegrityRuntimeException extends GeneralCustomRuntimeException {
    
    public DataIntegrityRuntimeException(String message, ErrorDetailDTO errorDetailDTO) {
        super(message, errorDetailDTO);
    }
}
