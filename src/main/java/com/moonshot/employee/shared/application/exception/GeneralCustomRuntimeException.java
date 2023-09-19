package com.moonshot.employee.shared.application.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class GeneralCustomRuntimeException extends RuntimeException {
    
    static final long serialVersionUID = 1L;

    String message;

    ErrorDetailDTO errorDetailDTO;

}
