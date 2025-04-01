package com.example.semillero.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceException extends Exception {

    private int statuscode;
    private String message;

    public ServiceException(String message, int statuscode) {
        this.message = message;
        this.statuscode = statuscode;
    }


    public ServiceException(String message, Throwable cause, String message1, int statuscode) {
        super(message, cause);
        this.message = message1;
        this.statuscode = statuscode;
    }
}
