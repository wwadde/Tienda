package com.digitalspace.api_clientes.controller;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.infra.erorres.ClienteException;
import com.digitalspace.api_clientes.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDatosDto> getClienteById(@PathVariable String id) throws ClienteException {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDatosDto>> getAllClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }


}