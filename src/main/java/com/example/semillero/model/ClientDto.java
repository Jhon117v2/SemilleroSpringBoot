package com.example.semillero.model;

//Tomamos solo los datos necesarios de la entidad en el dto

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {


    //private Long idClient;//Por ejemplo el id no es necesario ya que se auto genera


    private String strFirstName;

    private String strApellidos;


    private String strCedula;

    private String strEmail;

    private String strEstado;


    @Override
    public String toString() {
        return "ClientDto{" +
                "strApellidos='" + strApellidos + '\'' +
                ", strFirstName='" + strFirstName + '\'' +
                ", strCedula='" + strCedula + '\'' +
                ", strEmail='" + strEmail + '\'' +
                ", strEstado='" + strEstado + '\'' +
                '}';
    }
}
