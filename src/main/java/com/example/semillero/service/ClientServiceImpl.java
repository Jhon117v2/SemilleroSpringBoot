package com.example.semillero.service;

import com.example.semillero.entity.ClientEntity;
import com.example.semillero.enums.ExceptionEnum;
import com.example.semillero.exception.ServiceException;
import com.example.semillero.mapper.ClientMapper;
import com.example.semillero.model.ClientDto;
import com.example.semillero.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

//Recuerda realizar el mapeo para esta clase
@Service //Usamos el servicio para que nos de permisos
public class ClientServiceImpl implements IClientService {

    /*
     @Autowired //inyectamos la dependencia para no hacer un constructor,
     se puede usar en clases de acceso inferior
     @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper mapper;
     */

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

        if (clientDto == null) {
            throw new ServiceException(ExceptionEnum.REGISTER_NULL.getMessage(),
                    ExceptionEnum.REGISTER_NULL.getStatusCode());
        }
        if (clientDto.getStrFirstName() == null || clientDto.getStrFirstName().isEmpty()) {
            throw new ServiceException(ExceptionEnum.NAME_NULL.getMessage(),
                    ExceptionEnum.NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrApellidos() == null) {
            throw new ServiceException(ExceptionEnum.LAST_NAME_NULL.getMessage(),
                    ExceptionEnum.LAST_NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrCedula() == null) {
            throw new ServiceException(ExceptionEnum.DOCUMENT_NULL.getMessage(),
                    ExceptionEnum.DOCUMENT_NULL.getStatusCode());
        }
        if (clientDto.getStrEmail() == null) {
            throw new ServiceException(ExceptionEnum.EMAIL_NULL.getMessage(),
                    ExceptionEnum.EMAIL_NULL.getStatusCode());
        }
        if (clientDto.getStrEstado() == null) {
            throw new ServiceException(ExceptionEnum.STATE_NULL.getMessage(),
                    ExceptionEnum.STATE_NULL.getStatusCode());
        }

        //Se usa el objeto mapper
        ClientEntity client = mapper.clientMapper(clientDto);
        //Guardado de la informacion
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long id, ClientDto clientDto) throws ServiceException {
        if (clientDto == null) {
            throw new ServiceException(ExceptionEnum.REGISTER_NULL.getMessage(),
                    ExceptionEnum.REGISTER_NULL.getStatusCode());
        }
        if (clientDto.getStrFirstName() == null) {
            throw new ServiceException(ExceptionEnum.NAME_NULL.getMessage(),
                    ExceptionEnum.NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrApellidos() == null) {
            throw new ServiceException(ExceptionEnum.LAST_NAME_NULL.getMessage(),
                    ExceptionEnum.LAST_NAME_NULL.getStatusCode());
        }
        if (clientDto.getStrCedula() == null) {
            throw new ServiceException(ExceptionEnum.DOCUMENT_NULL.getMessage(),
                    ExceptionEnum.DOCUMENT_NULL.getStatusCode());
        }
        if (clientDto.getStrEmail() == null) {
            throw new ServiceException(ExceptionEnum.EMAIL_NULL.getMessage(),
                    ExceptionEnum.EMAIL_NULL.getStatusCode());
        }
        if (clientDto.getStrEstado() == null) {
            throw new ServiceException(ExceptionEnum.STATE_NULL.getMessage(),
                    ExceptionEnum.STATE_NULL.getStatusCode());
        }

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
