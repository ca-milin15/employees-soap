package com.moonshot.employee.employee;

import static org.springframework.ws.test.server.RequestCreators.withSoapEnvelope;
import static org.springframework.ws.test.server.ResponseMatchers.noFault;
import static org.springframework.ws.test.server.ResponseMatchers.serverOrReceiverFault;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.server.AutoConfigureMockWebServiceClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@SpringBootTest
@AutoConfigureMockWebServiceClient
public class EmployeeServiceImplIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MockWebServiceClient mockWebServiceClient;

    @BeforeEach
    public void init(){
        mockWebServiceClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Test
    void createEmployeeFailTest() {
        var stringSource = new StringSource(createEmployeeObject("PedroPedroPedroPedroPedroPedroPedroPedroPedroPedroPedroPedro"));

        mockWebServiceClient.sendRequest(withSoapEnvelope(stringSource))
            .andExpect(serverOrReceiverFault());
    }

    @Test
    void createEmployeeOkTest() {
        var stringSource = new StringSource(createEmployeeObject("Juan"));

        mockWebServiceClient.sendRequest(withSoapEnvelope(stringSource))
            .andExpect(noFault());
    }

    private String createEmployeeObject(String name){
        return String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:emp=\"http://moonshot.com/employees\">\r" +
            "    <soapenv:Header/>\r" +
            "    <soapenv:Body>\r" +
            "       <emp:EmployeeRequest>\r" +
            "           <emp:name>%s</emp:name>\r" +
            "           <emp:position>QA</emp:position>\r" +
            "           <emp:baseSalary>5666</emp:baseSalary>\r" +
            "       </emp:EmployeeRequest>\r" +
            "   </soapenv:Body>\r" +
            "</soapenv:Envelope>", name);
    }

    @Test
    void getEmployeeByIdOkTest() {
        var stringSource = new StringSource(createEmployeeObject("Julieta"));
        mockWebServiceClient.sendRequest(withSoapEnvelope(stringSource))
            .andExpect(noFault());

        var getEmployeeSource = new StringSource(getEmployeeObject("1"));
        mockWebServiceClient.sendRequest(withSoapEnvelope(getEmployeeSource))
            .andExpect(noFault());
    }

    @Test
    void getEmployeeByIdFailTest() {
        var getEmployeeSource = new StringSource(getEmployeeObject("100"));
        mockWebServiceClient.sendRequest(withSoapEnvelope(getEmployeeSource))
            .andExpect(serverOrReceiverFault());
    }

    private String getEmployeeObject(String id){
        return String.format("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:emp=\"http://moonshot.com/employees\">\r" +
            "   <soapenv:Header/>\r" +
            "    <soapenv:Body>\r" +
            "       <emp:EmployeeFindActionRequest>\r" +
            "           <emp:id>%s</emp:id>\r" +
            "       </emp:EmployeeFindActionRequest>\r" +
            "   </soapenv:Body>\r" +
            "</soapenv:Envelope>", id);
    }
}
