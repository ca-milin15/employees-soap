package com.moonshot.employee.shared.infrastructure;

import javax.xml.namespace.QName;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import com.moonshot.employee.shared.application.exception.GeneralCustomRuntimeException;

public class CustomExceptionResolver extends SoapFaultMappingExceptionResolver {

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        var exception = (GeneralCustomRuntimeException) ex;
        var faultDetail = fault.addFaultDetail();
        faultDetail.addFaultDetailElement(new QName("statusCode")).addText(exception.getErrorDetailDTO().getCode());
        faultDetail.addFaultDetailElement(new QName("reason")).addText(exception.getErrorDetailDTO().getDescription());
    }


}
