package com.william.clientes.service;

import com.william.clientes.domain.AuthResponse;
import com.william.clientes.domain.DatosRegistro;
import com.william.clientes.domain.UsuarioDto;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;

public interface UsuarioService {

    Long validarLogin(UsuarioDto dto) throws ClienteNoEncontradoException;

    AuthResponse registrarUsuarioEmpleado(DatosRegistro datosRegistro) throws ClienteException;

    AuthResponse login(UsuarioDto usuarioDto);
}
