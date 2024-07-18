package com.digitalspace.api_clientes.service;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;

import java.util.List;

public interface ClienteServiceInterface {


    List<ClienteDatosDto> listarClientes();

    ClienteDatosDto getClienteById(String id);
}
