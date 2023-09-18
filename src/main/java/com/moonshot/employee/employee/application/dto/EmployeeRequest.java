package com.moonshot.employee.employee.application.dto;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.moonshot.employee.employee.domain.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EmployeeRequest")
public class EmployeeRequest {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "position")
    private String position;

    @XmlElement(name = "baseSalary")
    private int baseSalary;

    public Employee toEntity() {
        return Employee.builder()
                .name(this.name)
                .position(this.position)
                .baseSalary(BigDecimal.valueOf(this.baseSalary))
                .build();
    }

    public EmployeeRequest() {}
}