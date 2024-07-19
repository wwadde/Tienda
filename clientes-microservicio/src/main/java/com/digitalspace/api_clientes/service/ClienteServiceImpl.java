package com.digitalspace.api_clientes.service;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.domain.ClienteEntity;
import com.digitalspace.api_clientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {



    private final ClienteRepository clienteRepository;

    private final Function<ClienteEntity, ClienteDatosDto> entityToClienteDatosDto;

    private final Function<ClienteDatosDto, ClienteEntity> dtoToClienteEntity;

    public ClienteServiceImpl(ClienteRepository clienteRepository,
                              Function<ClienteEntity, ClienteDatosDto> entityToClienteDatosDto,
                                Function<ClienteDatosDto, ClienteEntity> dtoToClienteEntity) {

        this.clienteRepository = clienteRepository;
        this.entityToClienteDatosDto = entityToClienteDatosDto;
        this.dtoToClienteEntity = dtoToClienteEntity;
    }

    @Override
    public List<ClienteDatosDto> listarClientes(){

        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes.stream().map(entityToClienteDatosDto).collect(Collectors.toList());
    }

    @Override
    public ClienteDatosDto getClienteById(String id) {
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow();
        return entityToClienteDatosDto.apply(cliente);

    }
}
