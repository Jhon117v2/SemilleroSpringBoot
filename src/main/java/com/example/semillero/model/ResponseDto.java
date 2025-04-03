package com.example.semillero.model;

import lombok.Getter;
import lombok.Setter;

//Este es un dto para obtener un mensaje de respuesta
@Getter
@Setter
public class ResponseDto {
    private int statusCode;
    private String message;

    // Constructor con parámetros
    public ResponseDto(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


}

