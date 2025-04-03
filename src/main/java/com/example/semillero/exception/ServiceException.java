package com.example.semillero.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ServiceException extends RuntimeException { //Con RuntimeException se evita el uso obligatorio de throws
    private final int statuscode;

    public ServiceException(String message, int statuscode) {
        super(message);
        this.statuscode = statuscode;
    }

}
