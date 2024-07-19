package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.RespuestaCliente;
import com.digitalspace.api_empleados.infra.errores.ClienteException;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.infra.errores.PermisosInsuficientesException;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmpleadoService {

    List<RespuestaCliente> getListaClientes(Long id) throws EmpleadoNoEncontradoException, PermisosInsuficientesException, ClienteException;
}
