package com.example.semillero.service;

import com.example.semillero.exception.ServiceException;
import com.example.semillero.model.ClientDto;

import java.util.List;

/**
 * Mircroservices to be called by a RESTful API.
 * Interface that contains the REST methods for ClientEntity.
 *
 * @author jhon, Oscar,Julian
 */

public interface IClientService {

    /**
     * HTTP GET method to get and show registers.
     */
    List<ClientDto> showAllClients();

    /**
     * HTTP GET method to get and show registers by id.
     *
     * @param id The id column to the ClientEntity.
     * @throws ServiceException Implementation of a personalized exception.
     */
    ClientDto getClientById(Long id) throws ServiceException;

    /**
     * HTTP POST method to create a new register.
     *
     * @param clientDto Registers of ClientEntity.
     * @throws ServiceException Implementation of a personalized exception.
     */
    void saveClient(ClientDto clientDto) throws ServiceException;

    /**
     * HTTP PUT method to update the entire fields of a register.
     *
     * @param id        The id column to the ClientEntity.
     * @param clientDto Registers of the ClientEntity.
     * @throws ServiceException Implementation of a personalized exception.
     */
    void updateClient(Long id, ClientDto clientDto) throws ServiceException;

    /**
     * HTTP DELETE method to delete a register.
     *
     * @param id The id column to the ClientEntity.
     * @throws ServiceException Implementation of a personalized exception.
     */
    void deleteClient(Long id) throws ServiceException;

    /**
     * @param id     The id column to the ClientEntity.
     * @param status The status colum to the ClientEntity.
     * @throws ServiceException Implementation of a personalized exception.
     */
    void updateClientStatus(Long id, String status) throws ServiceException;
}
