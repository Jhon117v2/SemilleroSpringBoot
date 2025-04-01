package com.example.semillero.controller;

import com.example.semillero.exception.ServiceException;
import com.example.semillero.model.ClientDto;
import com.example.semillero.model.ResponseDto;
import com.example.semillero.service.IClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Manejamos metodos basados en la arquitectura rest


@RestController
@RequestMapping(path = "/api")
public class ClientController {

    private static final Logger log = LogManager.getLogger(ClientController.class);

    @Autowired //bean que inyecta la implementacion de la clase
    private IClientService clientService;

    //Objeto de la clase DTO
    private ResponseDto responseDto = new ResponseDto();

    //Respuesta de creación del cliente, @RequestBody muy importante para el controlador y hacer peticiones json desde postman
    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDto> saveClient(@RequestBody ClientDto clientDto) {


        try {
            ResponseDto responseDto = new ResponseDto();

            log.info("OK controller: {}", clientDto.toString());
            //Respues en caso de positivo
            clientService.saveClient(clientDto);
            responseDto.setMessage("Solicitud exitosa");
            responseDto.setStatuscode(201);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            //Va a reponder un ResponseDTO
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    //Obtener todos los clientes

    //Respuesta de creación del cliente, @RequestBody muy importante para el controlador y hacer peticiones json desde postman
    //Los get no necesitan request boduy
    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ClientDto>> saveClient() {

        return ResponseEntity.ok(clientService.showAllClients());

    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) throws ServiceException {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<ResponseDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        try {
            clientService.updateClient(id, clientDto);
            responseDto.setMessage("Cliente actualizado con éxito");
            responseDto.setStatuscode(200);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseDto> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            responseDto.setMessage("Cliente eliminado con éxito");
            responseDto.setStatuscode(200);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    //Actualizar unicamente el estado
    @PatchMapping(path = "/updateStatus/{id}")
    public ResponseEntity<ResponseDto> updateClientStatus(@PathVariable Long id, @RequestBody String status) {
        try {
            clientService.updateClientStatus(id, status);
            responseDto.setMessage("Estado del cliente actualizado con éxito, id: " + id);
            responseDto.setStatuscode(200);
            return ResponseEntity.ok(responseDto);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

}
