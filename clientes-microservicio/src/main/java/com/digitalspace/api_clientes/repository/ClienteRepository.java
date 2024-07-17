package com.digitalspace.api_clientes.repository;

import com.digitalspace.api_clientes.domain.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteEntity, String> {
}
