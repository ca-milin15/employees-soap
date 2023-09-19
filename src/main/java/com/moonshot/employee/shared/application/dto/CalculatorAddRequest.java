package com.moonshot.employee.shared.application.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CalculatorAddRequest")
public class CalculatorAddRequest {

    @XmlElement(name = "firstValue")
    private double firstValue;

    @XmlElement(name = "secondValue")
    private double secondValue;
    
    
}
