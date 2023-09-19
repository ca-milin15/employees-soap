package com.moonshot.employee.employee.utility;

import com.moonshot.employee.shared.infrastructure.PropertiesSystem;

public class UtilitiesTest {

    public static PropertiesSystem.MessagesError initialiMessagesError(){
        var messages = new PropertiesSystem.MessagesError();
        messages.setEntityNotFound("El empleado con el ID: %s no existe.");
        messages.setGenericErrorMessage("Ha ocurrido un error inesperado. Consulte con el administrador.");
        messages.setApiIntegrationError("Ha ocurrido un error intentando conectarse con un API externa. Consulte con el administrador.");
        return messages;
    }
}
