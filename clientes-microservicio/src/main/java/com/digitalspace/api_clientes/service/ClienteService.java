package com.digitalspace.api_clientes.service;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;

import java.util.List;

public interface ClienteService {


    List<ClienteDatosDto> listarClientes();

    ClienteDatosDto getClienteById(String id);
}
