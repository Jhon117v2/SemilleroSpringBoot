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
        client.setStrApellidos(clientDto.getStrApellidos());
        client.setStrCedula(clientDto.getStrCedula());
        client.setStrEmail(clientDto.getStrEmail());
        client.setStrEstado(clientDto.getStrEstado());


        return client;
    }

    public ClientDto clientEntityToDTO(ClientEntity clientEntity) {

        ClientDto clientDto1 = new ClientDto();


        clientDto1.setStrFirstName(clientEntity.getStrFirstName());
        clientDto1.setStrApellidos(clientEntity.getStrApellidos());
        clientDto1.setStrCedula(clientEntity.getStrCedula());
        clientDto1.setStrEmail(clientEntity.getStrEmail());
        clientDto1.setStrEstado(clientEntity.getStrEstado());


        return clientDto1;
    }


}
