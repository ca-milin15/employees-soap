package com.moonshot.employee.employee.application.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum EmployeeStatusEnum {
    
    ACTIVE("ACTIVE");

    String description;
}
