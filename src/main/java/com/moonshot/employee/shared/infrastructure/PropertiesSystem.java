package com.moonshot.employee.shared.infrastructure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "message-system")
public class PropertiesSystem {

	MessagesError exceptions;

	@Setter
	@Getter
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class MessagesError {
		String genericErrorMessage;
        String entityNotFound;
		String apiIntegrationError;
    }
    
}
