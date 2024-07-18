package com.digitalspace.api_clientes.controller;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.service.ClienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteServiceImpl clienteServiceImpl;

    public ClienteController(ClienteServiceImpl clienteServiceImpl) {
        this.clienteServiceImpl = clienteServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDatosDto> getClienteById(@PathVariable String id){
        return ResponseEntity.ok(clienteServiceImpl.getClienteById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDatosDto>> getAllClientes(){
        return ResponseEntity.ok(clienteServiceImpl.listarClientes());
    }


}