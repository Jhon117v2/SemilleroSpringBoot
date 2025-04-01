package com.example.semillero.service;

import com.example.semillero.exception.ServiceException;
import com.example.semillero.model.ClientDto;

import java.util.List;

//Aqui estan los metodos y en la implementacion se sobreescriben
public interface IClientService {


    List<ClientDto> showAllClients();

    ClientDto getClientById(Long id) throws ServiceException;

    //Guardar los datos en el saveClient
    void saveClient(ClientDto clientDto) throws ServiceException;
    //Se debe crear una java Class, para implementar los metodos defenidos anteriormente

    void updateClient(Long id, ClientDto clientDto) throws ServiceException;

    void deleteClient(Long id) throws ServiceException;

    void updateClientStatus(Long id, String status) throws ServiceException;
}
