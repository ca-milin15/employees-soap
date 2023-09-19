package com.moonshot.employee.employee;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.noFault;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

public class EmployeeServiceImplIntegrationTest {


    @Test
    void createEmployeeFailTest() {
        var stringSource = new StringSource(
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:emp=\"http://moonshot.com/employees\">\r" +
            "    <soapenv:Header/>\r" +
            "   <soapenv:Body>\r" +
            "       <emp:EmployeeRequest>\r" +
            "           <emp:name>Juan</emp:name>\r" +
            "           <emp:position>QA</emp:position>\r" +
            "           <emp:baseSalary>5666</emp:baseSalary>\r" +
            "           <emp:name>Juan</emp:name>\r" +
            "       </emp:EmployeeRequest>\r" +
            "   </soapenv:Body>\r" +
            "</soapenv:Envelope>"
        );
        //mockWebServiceClient.sendRequest(withPayload(stringSource))
        //    .andExpect(noFault())
        //    .andExpect(payload(new StringSource(
        //        "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:emp=\"http://moonshot.com/employees\">\r" +
        //        "    <soapenv:Header/>\r" +
        //        "    <soapenv:Body>\r" +
        //        "        <emp:EmployeeResponse>\r" +
        //        "            <emp:status>ERROR</emp:status>\r" +
        //        "            <emp:code>400</emp:code>\r" +
        //        "            <emp:message>Bad Request</emp:message>\r" +
        //        "        </emp:EmployeeResponse>\r" +
        //        "    </soapenv:Body>\r" +
        //        "</soapenv:Envelope>"
        //    )))
        //    .andExpect(noFault())
        //    .andExpect(payload(stringSource));
    }
}
