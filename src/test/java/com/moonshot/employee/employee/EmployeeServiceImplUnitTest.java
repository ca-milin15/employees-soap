package com.moonshot.employee.employee;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import com.moonshot.employee.employee.application.dto.EmployeeFindActionRequest;
import com.moonshot.employee.employee.application.dto.EmployeeFindActionResponse;
import com.moonshot.employee.employee.application.dto.EmployeeRequest;
import com.moonshot.employee.employee.application.dto.EmployeeResponse;
import com.moonshot.employee.employee.application.exceptions.DataIntegrityRuntimeException;
import com.moonshot.employee.employee.application.exceptions.EmployeeNotFoundRuntimeException;
import com.moonshot.employee.employee.application.service.EmployeeServiceImpl;
import com.moonshot.employee.employee.domain.Employee;
import com.moonshot.employee.employee.domain.EmployeeRepository;
import com.moonshot.employee.employee.utility.UtilitiesTest;
import com.moonshot.employee.shared.infrastructure.PropertiesSystem;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplUnitTest {
    
    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    PropertiesSystem propertiesSystem;

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

    @Test
    @DisplayName("This method evaluates the getEmployeeById method of EmployeeServiceImpl when the employee is not present in DB.")
    void getEmployeeByIdUnitTestFailCase() {    
        when(employeeRepository.findById(any())).thenReturn(Optional.empty());
        when(propertiesSystem.getExceptions()).thenReturn(UtilitiesTest.initialiMessagesError());

        assertThrows(EmployeeNotFoundRuntimeException.class,
                () -> employeeServiceImpl.getEmployeeById(createEmployeeFindActionRequest()));
    }

    private EmployeeFindActionRequest createEmployeeFindActionRequest() {
        return new EmployeeFindActionRequest(Long.valueOf(1));
    }

    @Test
    @DisplayName("This method evaluates the getEmployeeById method of EmployeeServiceImpl when it works ok.")
    void getEmployeeByIdUnitTestOkCase() {    
        when(employeeRepository.findById(any())).thenReturn(createEmployeeObject());

        var response = employeeServiceImpl.getEmployeeById(createEmployeeFindActionRequest());
        assertInstanceOf(EmployeeFindActionResponse.class, response);
    }

    private Optional<Employee> createEmployeeObject() {
        return Optional.of(new Employee(Long.valueOf(1), "Camilo", "dev", BigDecimal.valueOf(1)));
    }

}
