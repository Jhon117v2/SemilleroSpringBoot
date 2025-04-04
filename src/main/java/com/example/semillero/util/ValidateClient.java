package com.example.semillero.util;

import com.example.semillero.enums.ExceptionEnum;
import com.example.semillero.exception.ServiceException;
import com.example.semillero.model.ClientDto;

public class ValidateClient {


    public static void validateClient(ClientDto clientDto) throws ServiceException {

        if (clientDto == null) {
            throw new ServiceException(ExceptionEnum.REGISTER_NULL.getMessage(),
                    ExceptionEnum.REGISTER_NULL.getStatusCode());
        }
        if (clientDto.getStrFirstName() == null || clientDto.getStrFirstName().isEmpty()) {
            throw new ServiceException(ExceptionEnum.NAME_NULL.getMessage(),
                    ExceptionEnum.NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrLastName() == null || clientDto.getStrLastName().isEmpty()) {
            throw new ServiceException(ExceptionEnum.LAST_NAME_NULL.getMessage(),
                    ExceptionEnum.LAST_NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrIdentificationNumber() == null || clientDto.getStrIdentificationNumber().isEmpty()) {
            throw new ServiceException(ExceptionEnum.DOCUMENT_NULL.getMessage(),
                    ExceptionEnum.DOCUMENT_NULL.getStatusCode());
        }
        if (clientDto.getStrEmail() == null || clientDto.getStrEmail().isEmpty()) {
            throw new ServiceException(ExceptionEnum.EMAIL_NULL.getMessage(),
                    ExceptionEnum.EMAIL_NULL.getStatusCode());
        }
        if (clientDto.getStrState() == null || clientDto.getStrState().isEmpty()) {
            throw new ServiceException(ExceptionEnum.STATE_NULL.getMessage(),
                    ExceptionEnum.STATE_NULL.getStatusCode());
        }

    }
}