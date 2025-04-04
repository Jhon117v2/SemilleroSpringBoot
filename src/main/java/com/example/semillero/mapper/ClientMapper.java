package com.example.semillero.mapper;

import com.example.semillero.entity.ClientEntity;
import com.example.semillero.model.ClientDto;

//Mapeo
public class ClientMapper {

    //Inyeccion de dependencias mediante el constructor de la clase
   /* private final ClientDto clientDto;

    public ClientMapper(ClientDto clientDto) {
        this.clientDto = clientDto;
    }*/

    public ClientEntity clientMapper(ClientDto clientDto) {

        ClientEntity client = new ClientEntity(); // Se inicializa

        client.setStrFirstName(clientDto.getStrFirstName());
        client.setStrLastName(clientDto.getStrLastName());
        client.setStrIdentificationNumber(clientDto.getStrIdentificationNumber());
        client.setStrEmail(clientDto.getStrEmail());
        client.setStrState(clientDto.getStrState());


        return client;
    }

    public ClientDto clientEntityToDTO(ClientEntity clientEntity) {

        ClientDto clientDto1 = new ClientDto();


        clientDto1.setStrFirstName(clientEntity.getStrFirstName());
        clientDto1.setStrLastName(clientEntity.getStrLastName());
        clientDto1.setStrIdentificationNumber(clientEntity.getStrIdentificationNumber());
        clientDto1.setStrEmail(clientEntity.getStrEmail());
        clientDto1.setStrState(clientEntity.getStrState());


        return clientDto1;
    }


}
