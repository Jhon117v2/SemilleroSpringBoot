package com.example.semillero.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {

    REGISTER_NULL ("Contenido del Registro nulo", 400),
    NAME_NULL("Primer nombre no puede ser nulo o vacío",400),
    LAST_NAME_NULL("Apellido no puede ser nulo o vacío",400),
    CLIENT_NOT_FOUND("Usuario no registrado", 404),
    DOCUMENT_NULL ("Documento no puede ser nulo o vacío",400),
    EMAIL_NULL ("Correo electrónico no puede ser nulo o vacío",400),
    STATE_NULL ("Estado no puede ser nulo o vacío",400);

    private final String message;
    private final int statusCode;

}
