package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.RespuestaCliente;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmpleadoService {

    Mono<List<RespuestaCliente>> getListaClientes(Long id);
}
