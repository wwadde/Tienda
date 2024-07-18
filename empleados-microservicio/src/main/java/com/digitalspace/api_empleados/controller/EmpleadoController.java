package com.digitalspace.api_empleados.controller;

import com.digitalspace.api_empleados.domain.RespuestaCliente;
import com.digitalspace.api_empleados.service.EmpleadoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoServiceImpl empleadoServiceImpl;

    public EmpleadoController(EmpleadoServiceImpl empleadoServiceImpl) {
        this.empleadoServiceImpl = empleadoServiceImpl;
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<List<RespuestaCliente>>> getClientes(@PathVariable Long id) {
        Mono<List<RespuestaCliente>> listaClientes = empleadoServiceImpl.getListaClientes(id);
        return ResponseEntity.ok(listaClientes);
    }
}
