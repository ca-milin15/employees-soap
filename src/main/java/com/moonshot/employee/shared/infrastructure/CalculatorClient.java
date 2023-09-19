package com.moonshot.employee.shared.infrastructure;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.moonshot.employee.shared.application.dto.CalculatorAddRequest;
import com.moonshot.employee.shared.application.dto.CalculatorAddResponse;

@Service
public class CalculatorClient extends org.springframework.ws.client.core.support.WebServiceGatewaySupport {
    
    @Autowired
    Jaxb2Marshaller marshallerInjected;


    WebServiceTemplate template;

    public Object callWebService(CalculatorAddRequest request) throws JAXBException{
        template = new WebServiceTemplate(marshallerInjected);
        return template.marshalSendAndReceive(
            "http://localhost:8081/ws", request, 
            new SoapActionCallback("http://moonshot.com/calculator-ws/add"));
    }
}
