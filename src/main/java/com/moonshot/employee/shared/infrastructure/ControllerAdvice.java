package com.moonshot.employee.shared.infrastructure;

import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;

public class ControllerAdvice implements ClientInterceptor{

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        throw new UnsupportedOperationException("Unimplemented method 'handleRequest'");
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        throw new UnsupportedOperationException("Unimplemented method 'handleResponse'");
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        throw new UnsupportedOperationException("Unimplemented method 'handleFault'");
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception ex) throws WebServiceClientException {
        throw new UnsupportedOperationException("Unimplemented method 'afterCompletion'");
    }
}
