package com.moonshot.employee.employee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;
import com.moonshot.employee.employee.application.exceptions.DataIntegrityRuntimeException;
import com.moonshot.employee.employee.application.service.EmployeeServiceImpl;
import com.moonshot.employee.employee.domain.Employee;
import com.moonshot.employee.employee.domain.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplUnitTest {
    
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    @DisplayName("This method evaluates the addEmployee method of EmployeeServiceImpl when DB is throw an exception")
    void addEmployeeUnitTestFailCase() {    
        when(employeeRepository.save(any())).thenThrow(new DataIntegrityViolationException("Error"));

        assertThrows(DataIntegrityRuntimeException.class,
                () -> employeeServiceImpl.addEmployee(createEmployeeRequest()));
    }

    @Test
    @DisplayName("This method evaluates the addEmployee method of EmployeeServiceImpl when is working ok")
    void addEmployeeUnitTestOkCase() {    
        when(employeeRepository.save(any())).thenReturn(createEmployeeDomain());

        var response = employeeServiceImpl.addEmployee(createEmployeeRequest());
        assertInstanceOf(EmployeeResponse.class, response);
    }

    private Employee createEmployeeDomain() {
        return new Employee(Long.valueOf(1), "Camilo", "dev", BigDecimal.valueOf(1));
    }

    private EmployeeRequest createEmployeeRequest() {
        return new EmployeeRequest("Camilo", "dev", 0);
    }
}
