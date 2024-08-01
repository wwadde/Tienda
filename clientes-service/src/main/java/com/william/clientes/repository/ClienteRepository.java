package com.william.clientes.repository;

import com.william.clientes.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByUsuarioId(Long usuarioId);

}
