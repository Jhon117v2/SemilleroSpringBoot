package com.example.semillero.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CLIENT") // Cambia el nombre de la tabla
public class ClientEntity {

    @Id
    //Control p para ver los varoes que espera
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "NUM_ID_CLIENT")
    private Long idClient;//Para buscar el articulo por ID y que no se pueda repetir

    @Column(name = "STR_FIRST_NAME")
    private String strFirstName;
    @Column(name = "STR_LAST_NAME")
    private String strApellidos;
    @Column(name = "STR_IDENTIFICATION_NUMBER")
    private String strCedula;
    @Column(name = "STR_EMAIL")
    private String strEmail;

    @Column(name = "STR_STATE")
    private String strEstado;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

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
}
