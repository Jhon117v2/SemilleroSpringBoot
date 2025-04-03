package com.example.semillero.service;

import com.example.semillero.entity.ClientEntity;
import com.example.semillero.enums.ExceptionEnum;
import com.example.semillero.exception.ServiceException;
import com.example.semillero.mapper.ClientMapper;
import com.example.semillero.model.ClientDto;
import com.example.semillero.repository.ClientRepository;
import com.example.semillero.util.ValidateClient;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service //Usamos el servicio para que nos de permisos
public class ClientServiceImpl implements IClientService {


    //En caso de no usar el @Autowired, usamos lo siguiente con el constructor
    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    //Se inyecta las dependencias gracias al bean de ClientMapper
    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }
    
    @Override
    public ClientDto getClientById(Long id) throws ServiceException {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        ExceptionEnum.CLIENT_NOT_FOUND.getMessage(),
                        ExceptionEnum.CLIENT_NOT_FOUND.getStatusCode()));
        return mapper.clientEntityToDTO(client);
    }

    //Microservicio terminado para obtener clientes, se necesita controlador para acceder
    @Override
    public List<ClientDto> showAllClients() {
        //Se devuelve un producto co nstream
        return clientRepository.findAll().stream()
                .map(clientEntity -> mapper.clientEntityToDTO(clientEntity))
                .toList();

    }

    @Override
    public void saveClient(ClientDto clientDto) throws ServiceException {

        ValidateClient.validateClient(clientDto);


        //Se usa el objeto mapper para guardado
        ClientEntity client = mapper.clientMapper(clientDto);
        clientRepository.save(client);
    }

    @Transactional
    @Override
    public void updateClient(Long id, ClientDto clientDto) throws ServiceException {
        ValidateClient.validateClient(clientDto);

        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        ExceptionEnum.CLIENT_NOT_FOUND.getMessage(),
                        ExceptionEnum.CLIENT_NOT_FOUND.getStatusCode()));

        client.setStrFirstName(clientDto.getStrFirstName());
        client.setStrApellidos(clientDto.getStrApellidos());
        client.setStrCedula(clientDto.getStrCedula());
        client.setStrEmail(clientDto.getStrEmail());
        client.setStrEstado(clientDto.getStrEstado());

        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) throws ServiceException {
        if (!clientRepository.existsById(id)) {
            throw new ServiceException(ExceptionEnum.CLIENT_NOT_FOUND.getMessage(),
                    ExceptionEnum.CLIENT_NOT_FOUND.getStatusCode());
        }
        clientRepository.deleteById(id);
    }

    //Aplicacion del patch
    @Transactional
    @Override
    public void updateClientStatus(Long id, String status) throws ServiceException {
        ClientEntity client = clientRepository.findById(id)
                .orElseThrow(() -> new ServiceException(
                        ExceptionEnum.CLIENT_NOT_FOUND.getMessage(),
                        ExceptionEnum.CLIENT_NOT_FOUND.getStatusCode()));
        client.setStrEstado(status);
        clientRepository.save(client);
    }
}
