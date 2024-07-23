package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.UsuarioDto;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;

public interface UsuarioService {

    Long validarUsuario(UsuarioDto dto) throws EmpleadoNoEncontradoException;
}
