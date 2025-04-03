package com.example.semillero.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration Se registra en el contexto de Spring, al eliminarlo no lo reconocera en ClientServiceImpl.
 * @Bean Spring indentifica el bean de ClientMapper
 */
@Configuration
public class MapperConfig {

    @Bean
    public ClientMapper mapper() {
        return new ClientMapper();
    }
}
