package com.example.semillero.model;

//Este es un dto para obtener un mensaje de respuesta
public class ResponseDto {

    private int statuscode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    private String message;
}
