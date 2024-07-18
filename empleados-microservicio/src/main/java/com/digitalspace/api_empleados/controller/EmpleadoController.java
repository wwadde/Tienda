package com.digitalspace.api_empleados.controller;

import com.digitalspace.api_empleados.domain.RespuestaCliente;
import com.digitalspace.api_empleados.service.EmpleadoService;
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

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmpleados(@PathVariable Long id) {
        Mono<List<RespuestaCliente>> listaEmpleados = empleadoService.getListaClientes(id);
        return ResponseEntity.ok(listaEmpleados);
    }
}
