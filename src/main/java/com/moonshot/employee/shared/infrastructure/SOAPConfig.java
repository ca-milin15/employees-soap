package com.moonshot.employee.shared.infrastructure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SOAPConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.moonshot.employee");
        return marshaller;
    }

    //@Bean
    //public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
    //    CalculatorClient client = new CalculatorClient();
    //    client.setDefaultUri("http://localhost:8081/ws");
    //    client.setMarshaller(marshaller);
    //    client.setUnmarshaller(marshaller);
    //    return client;
    //}
}
