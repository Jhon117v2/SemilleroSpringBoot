package com.example.semillero.controller;

import com.example.semillero.enums.RespondEnum;
import com.example.semillero.exception.ServiceException;
import com.example.semillero.model.ClientDto;
import com.example.semillero.model.ResponseDto;
import com.example.semillero.service.IClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@RestController
@RequestMapping(path = "/api")
public class ClientController {

    private static final Logger log = LogManager.getLogger(ClientController.class);


    private final IClientService clientService;


    //Se inyecta las dependencias por constructor
    public ClientController(IClientService clientService) {
        this.clientService = clientService;

    }


    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDto> saveClient(@RequestBody ClientDto clientDto) {
        try {
            log.info("OK controller: {}", clientDto.toString());
            clientService.saveClient(clientDto);
            return ResponseEntity.status(RespondEnum.SAVE.getStatusCode()).body(
                    new ResponseDto(RespondEnum.SAVE.getStatusCode(), RespondEnum.SAVE.getMessage()));
        } catch (ServiceException e) {
            return ResponseEntity.status(e.getStatuscode()).body(new ResponseDto(e.getStatuscode(), e.getMessage()));
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ClientDto>> getAllClients() {
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
            return ResponseEntity.status(RespondEnum.UDATE.getStatusCode()).body(
                    new ResponseDto(RespondEnum.UDATE.getStatusCode(), RespondEnum.UDATE.getMessage()));
        } catch (ServiceException e) {
            return ResponseEntity.status(e.getStatuscode()).body(new ResponseDto(e.getStatuscode(), e.getMessage()));
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<ResponseDto> deleteClient(@PathVariable Long id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok(new ResponseDto(RespondEnum.DELETE.getStatusCode(),
                    RespondEnum.DELETE.getMessage()));
        } catch (ServiceException e) {
            return new ResponseEntity<>(new ResponseDto(RespondEnum.DELETE.getStatusCode(),
                    RespondEnum.ERROR.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }

    @PatchMapping(path = "/updateStatus/{id}")
    public ResponseEntity<ResponseDto> updateClientStatus(@PathVariable Long id, @RequestBody String status) {
        try {
            clientService.updateClientStatus(id, status);
            return ResponseEntity.ok(new ResponseDto(RespondEnum.UDATE.getStatusCode(),
                    RespondEnum.UDATE.getMessage() + "id: " + id));
        } catch (ServiceException e) {
            return new ResponseEntity<>(new ResponseDto(RespondEnum.DELETE.getStatusCode(),
                    RespondEnum.ERROR.getMessage()), HttpStatus.BAD_GATEWAY);
        }
    }
}
