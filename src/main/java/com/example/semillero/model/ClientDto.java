package com.example.semillero.model;

//Tomamos solo los datos necesarios de la entidad en el dto

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {


    //private Long idClient;//Por ejemplo el id no es necesario ya que se auto genera


    private String strFirstName;

    private String strLastName;


    private String strIdentificationNumber;

    private String strEmail;

    private String strState;


    @Override
    public String toString() {
        return "ClientDto{" +
                "strApellidos='" + strLastName + '\'' +
                ", strFirstName='" + strFirstName + '\'' +
                ", strCedula='" + strIdentificationNumber + '\'' +
                ", strEmail='" + strEmail + '\'' +
                ", strEstado='" + strState + '\'' +
                '}';
    }
}
