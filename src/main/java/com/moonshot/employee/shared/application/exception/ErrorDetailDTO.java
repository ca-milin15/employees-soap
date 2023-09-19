package com.moonshot.employee.shared.application.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorDetailDTO", propOrder = {
    "code",
    "description"
})
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ErrorDetailDTO {
    
    String code;
    String description;
}
