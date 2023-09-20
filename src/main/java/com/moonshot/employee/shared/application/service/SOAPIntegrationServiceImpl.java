package com.moonshot.employee.shared.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.moonshot.employee.shared.application.dto.CalculatorAddRequest;
import com.moonshot.employee.shared.application.dto.CalculatorAddResponse;
import com.moonshot.employee.shared.application.exception.APIIntegrationErrorRuntimeException;
import com.moonshot.employee.shared.application.exception.ErrorDetailDTO;
import com.moonshot.employee.shared.infrastructure.PropertiesSystem;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SOAPIntegrationServiceImpl extends org.springframework.ws.client.core.support.WebServiceGatewaySupport implements IntegrationService {

    @Autowired
    Jaxb2Marshaller marshallerInjected;

    @Autowired
    PropertiesSystem propertiesSystem;

    WebServiceTemplate template;


    final String CALCULATOR_WS_URL = "http://localhost:8081/ws";
    final String SOAP_ACTION_CALLBACK = "http://moonshot.com/calculator-ws/add";

    @Override
    public Object consumeService(CalculatorAddRequest payload) {
        try {
            log.info("Preperando Comunicacion con API externa: {}", payload.toString());
            template = new WebServiceTemplate(marshallerInjected);
            var response = (CalculatorAddResponse) template.marshalSendAndReceive(
                CALCULATOR_WS_URL, payload, 
                new SoapActionCallback(SOAP_ACTION_CALLBACK));
            log.info("Comunicacion con API externa exitosa: {}", response.toString());
            return response;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new APIIntegrationErrorRuntimeException(
                propertiesSystem.getExceptions().getGenericErrorMessage(),
                new ErrorDetailDTO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), propertiesSystem.getExceptions().getApiIntegrationError()));
        }
    }
    
}
