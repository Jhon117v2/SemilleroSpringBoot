package com.example.semillero.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    //Se registra en el contexto de Spring, al eliminarlo no lo reconocera en ClientServiceImpl
    @Bean // Spring indentifica el bean de ClientMapper
    public ClientMapper mapper() {
        return new ClientMapper();
    }
}
