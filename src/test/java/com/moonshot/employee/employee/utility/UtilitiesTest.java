package com.moonshot.employee.employee.utility;

import com.moonshot.employee.shared.infrastructure.PropertiesSystem;

public class UtilitiesTest {

    public static PropertiesSystem.MessagesError initialiMessagesError(){
        var messages = new PropertiesSystem.MessagesError();
        messages.setEntityNotFound("El empleado con el ID: %s no existe.");
        return messages;
    }
}
