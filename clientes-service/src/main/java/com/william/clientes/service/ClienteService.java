package com.william.clientes.service;

import com.william.clientes.domain.DatosClienteFront;
import com.william.clientes.domain.RespuestaProductos;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;
import com.william.clientes.infra.errores.PermisosInsuficientesException;
import com.william.clientes.infra.errores.TokenException;

import java.util.List;

public interface ClienteService {

    List<RespuestaProductos> getListaProductos() throws ClienteNoEncontradoException, PermisosInsuficientesException, ClienteException;

    DatosClienteFront poblarDatosClienteFront(Long usuarioId) throws ClienteNoEncontradoException;

    Boolean validarRol(String token) throws TokenException, ClienteException;
}

