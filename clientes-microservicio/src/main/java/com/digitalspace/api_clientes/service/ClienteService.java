package com.digitalspace.api_clientes.service;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.domain.ClienteEntity;
import com.digitalspace.api_clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {



    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDatosDto> listarClientes(){

        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDatosDto::new).toList();
    }

    public ClienteDatosDto getClienteById(String id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow();
        return new ClienteDatosDto(cliente);

    }
}
