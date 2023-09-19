package com.moonshot.employee.employee.application.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.moonshot.employee.employee.application.dto.EmployeeFindActionRequest;
import com.moonshot.employee.employee.application.dto.EmployeeFindActionResponse;
import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;
import com.moonshot.employee.employee.application.enums.EmployeeStatusEnum;
import com.moonshot.employee.employee.application.exceptions.DataIntegrityRuntimeException;
import com.moonshot.employee.employee.application.exceptions.EmployeeNotFoundRuntimeException;
import com.moonshot.employee.employee.domain.Employee;
import com.moonshot.employee.employee.domain.EmployeeRepository;
import com.moonshot.employee.shared.application.dto.CalculatorAddRequest;
import com.moonshot.employee.shared.application.dto.CalculatorAddResponse;
import com.moonshot.employee.shared.application.service.IntegrationService;
import com.moonshot.employee.shared.infrastructure.PropertiesSystem;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;
    PropertiesSystem propertiesSystem;
    IntegrationService integrationService;

    @Override
    @Transactional
    public EmployeeResponse addEmployee(EmployeeRequest employeeDTO) {
        var employee = employeeDTO.toEntity();
        var baseSalaryAddBonus = connectToCalculateBonus(employeeDTO.getBaseSalary());
        employee.setBaseSalary(BigDecimal.valueOf(baseSalaryAddBonus));
        return buildObjectResponse(persistOnDB(employee));
    }

    static final double BONUS_SALARY = 1000.0;

    private double connectToCalculateBonus(double baseSalary) {
        var calculatorAddRequest = new CalculatorAddRequest(baseSalary, BONUS_SALARY);
        var calculatorAddResponseAsObject = integrationService.consumeService(calculatorAddRequest);
        var calculatorAddResponse = (CalculatorAddResponse) calculatorAddResponseAsObject;
        return calculatorAddResponse.getTotalValue();
    }

    private Employee persistOnDB(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityRuntimeException(e.getMessage());
        }
    }

    private EmployeeResponse buildObjectResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .status(EmployeeStatusEnum.ACTIVE.getDescription())
                .build();
    }

    @Override
    public EmployeeFindActionResponse getEmployeeById(EmployeeFindActionRequest employeeFindActionRequestmployeeFindActionRequest) {
        var employeeAsEntity = findByIdCustomMethod(employeeFindActionRequestmployeeFindActionRequest.getId());
        return buildEmployeeFindActionResponseObject(employeeAsEntity);
    }

    private Employee findByIdCustomMethod(Long id) {
        return employeeRepository.findById(id).orElseThrow(
            () -> new EmployeeNotFoundRuntimeException(
                String.format(propertiesSystem.getExceptions().getEntityNotFound(), id)));
    }

    private EmployeeFindActionResponse buildEmployeeFindActionResponseObject(Employee employee) {
        return EmployeeFindActionResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .position(employee.getPosition())
                .baseSalary(employee.getBaseSalary().intValue())
                .build();
    }
    
}
