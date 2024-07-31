package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.AuthResponse;
import com.digitalspace.api_empleados.domain.DatosRegistro;
import com.digitalspace.api_empleados.domain.UsuarioDto;
import com.digitalspace.api_empleados.infra.errores.EmpleadoException;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;

public interface UsuarioService {

    Long validarLogin(UsuarioDto dto) throws EmpleadoNoEncontradoException;

    AuthResponse registrarUsuarioEmpleado(DatosRegistro datosRegistro) throws EmpleadoException;

    AuthResponse login(UsuarioDto usuarioDto);
}
