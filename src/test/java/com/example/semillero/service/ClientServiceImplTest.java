package com.example.semillero.service;

import com.example.semillero.entity.ClientEntity;
import com.example.semillero.exception.ServiceException;
import com.example.semillero.mapper.ClientMapper;
import com.example.semillero.model.ClientDto;
import com.example.semillero.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper mapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    private ClientDto clientDto;
    private ClientEntity clientEntity;

    @BeforeEach
    void setUp() {
        clientDto = new ClientDto();
        clientDto.setStrFirstName("John");
        clientDto.setStrLastName("Doe");
        clientDto.setStrIdentificationNumber("123456");
        clientDto.setStrEmail("john@example.com");
        clientDto.setStrState("Activo");

        clientEntity = new ClientEntity();
        clientEntity.setStrFirstName("John");
        clientEntity.setStrLastName("Doe");
        clientEntity.setStrIdentificationNumber("123456");
        clientEntity.setStrEmail("john@example.com");
        clientEntity.setStrState("Activo");
    }

    @Test
    void getClientById_ValidId_ReturnsClientDto() throws ServiceException {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(clientEntity));
        when(mapper.clientEntityToDTO(clientEntity)).thenReturn(clientDto);

        ClientDto result = clientService.getClientById(1L);

        assertEquals(clientDto.getStrEmail(), result.getStrEmail());
    }

    @Test
    void getClientById_NotFound_ThrowsException() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> clientService.getClientById(1L));
    }

    @Test
    void showAllClients_ReturnsListOfClientDto() {
        List<ClientEntity> entities = List.of(clientEntity);
        when(clientRepository.findAll()).thenReturn(entities);
        when(mapper.clientEntityToDTO(any())).thenReturn(clientDto);

        List<ClientDto> result = clientService.showAllClients();

        assertEquals(1, result.size());
    }

    @Test
    void saveClient_ValidDto_SavesEntity() throws ServiceException {
        when(mapper.clientMapper(clientDto)).thenReturn(clientEntity);

        clientService.saveClient(clientDto);

        verify(clientRepository).save(clientEntity);
    }

    @Test
    void updateClient_ValidId_UpdatesClient() throws ServiceException {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(clientEntity));

        clientService.updateClient(1L, clientDto);

        verify(clientRepository).save(any(ClientEntity.class));
    }

    @Test
    void updateClient_NotFound_ThrowsException() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> clientService.updateClient(1L, clientDto));
    }

    @Test
    void deleteClient_ValidId_DeletesClient() throws ServiceException {
        when(clientRepository.existsById(1L)).thenReturn(true);

        clientService.deleteClient(1L);

        verify(clientRepository).deleteById(1L);
    }

    @Test
    void deleteClient_NotFound_ThrowsException() {
        when(clientRepository.existsById(1L)).thenReturn(false);

        assertThrows(ServiceException.class, () -> clientService.deleteClient(1L));
    }

    @Test
    void updateClientStatus_ValidId_UpdatesStatus() throws ServiceException {
        when(clientRepository.findById(1L)).thenReturn(Optional.of(clientEntity));

        clientService.updateClientStatus(1L, "Inactivo");

        verify(clientRepository).save(clientEntity);
        assertEquals("Inactivo", clientEntity.getStrState());
    }

    @Test
    void updateClientStatus_NotFound_ThrowsException() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ServiceException.class, () -> clientService.updateClientStatus(1L, "Inactivo"));
    }

}
