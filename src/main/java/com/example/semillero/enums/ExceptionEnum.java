package com.example.semillero.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {

    REGISTER_NULL("Contenido del Registro nulo", 400),
    NAME_NULL("El campo Nombre es requerido", 400),
    LAST_NAME_NULL("El campo Apellido es requerido", 400),
    CLIENT_NOT_FOUND("Usuario no registrado", 404),
    DOCUMENT_NULL("El campo Cedula es requerido", 400),
    EMAIL_NULL("El campo Email es requerido", 400),
    STATE_NULL("El campo Estado es requerido", 400);

    private final String message;
    private final int statusCode;

}
