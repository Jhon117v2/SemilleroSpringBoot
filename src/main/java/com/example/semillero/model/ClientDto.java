package com.example.semillero.model;

//Tomamos solo los datos necesarios de la entidad en el dto

public class ClientDto {


    //private Long idClient;//Por ejemplo el id no es necesario ya que se auto genera


    private String strFirstName;

    private String strApellidos;


    private String strCedula;

    private String strEmail;

    private String strEstado;

    public String getStrApellidos() {
        return strApellidos;
    }

    public void setStrApellidos(String strApellidos) {
        this.strApellidos = strApellidos;
    }

    public String getStrCedula() {
        return strCedula;
    }

    public void setStrCedula(String strCedula) {
        this.strCedula = strCedula;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrEstado() {
        return strEstado;
    }

    public void setStrEstado(String strEstado) {
        this.strEstado = strEstado;
    }

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

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
