package com.moonshot.employee.shared.application.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import com.moonshot.employee.shared.application.dto.CalculatorAddRequest;
import com.moonshot.employee.shared.application.dto.CalculatorAddResponse;
import com.moonshot.employee.shared.infrastructure.CalculatorClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SOAPIntegrationService implements IntegrationService {

    Jaxb2Marshaller marshaller;
    CalculatorClient calculatorClient;

    @Override
    public Object consumeService(CalculatorAddRequest payload) {
        try {
            return (CalculatorAddResponse) calculatorClient.callWebService(payload);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
    
}
