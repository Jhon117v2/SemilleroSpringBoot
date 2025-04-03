package com.example.semillero.repository;

import com.example.semillero.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Debemos pasar la información del Client DTO al client entity, Es decir entity to dto to entity
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
