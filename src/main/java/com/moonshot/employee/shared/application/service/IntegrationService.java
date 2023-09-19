package com.moonshot.employee.shared.application.service;

import com.moonshot.employee.shared.application.dto.CalculatorAddRequest;

public interface  IntegrationService {
    
    Object consumeService(CalculatorAddRequest calculatorAddRequest);
}
