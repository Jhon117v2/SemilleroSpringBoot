package com.example.semillero.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RespondEnum {

    SAVE(201, "Registro creado correctamente."),
    UDATE(200, "Registro actualizado con éxito."),
    DELETE(200, "Registro eliminado."),
    ERROR(502, "Error al eliminar registro.");

    private final int statusCode;
    private final String message;
}
