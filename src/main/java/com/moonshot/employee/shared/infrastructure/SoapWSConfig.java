package com.moonshot.employee.shared.infrastructure;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.moonshot.employee.utility.Utilities;

@EnableWs
@Configuration
public class SoapWSConfig extends WsConfigurerAdapter{

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        var messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(applicationContext);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/ws/*") ;
    }

    @Bean(name = "employee")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
        var defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("EmployeePort");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace(Utilities.NAME_SPACE);
        defaultWsdl11Definition.setSchema(xsdSchema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema xsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employees.xsd"));
    }

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        var exceptionResolver = new CustomExceptionResolver();
        exceptionResolver.setOrder(1);

        var soapFaultDefinition = new SoapFaultDefinition();
        soapFaultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
        exceptionResolver.setDefaultFault(soapFaultDefinition);
        return exceptionResolver;
    }
}