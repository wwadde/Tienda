package com.digitalspace.api_empleados.repository;

import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    Optional<EmpleadoEntity> findByUsuarioId(Long usuarioId);

}
