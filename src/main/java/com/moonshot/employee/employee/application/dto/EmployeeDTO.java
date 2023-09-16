package com.moonshot.employee.employee.application.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.moonshot.employee.employee.domain.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeDTO", propOrder = {
    "name",
    "position",
    "baseSalary"
})
@XmlRootElement(name = "EmployeeDTO")
public class EmployeeDTO {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "position")
    private String position;

    @XmlElement(name = "baseSalary")
    private Double baseSalary;

    public Employee toEntity() {
        return null;
    }

}