package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.Cargo;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.RespuestaCliente;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmpleadoService {


    private final WebClient webClient;

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(WebClient webClient, EmpleadoRepository empleadoRepository) {
        this.webClient = webClient;
        this.empleadoRepository = empleadoRepository;
    }

    public Mono<List<RespuestaCliente>> getEmpleados(Long id) {

        Optional<EmpleadoEntity> empleado = empleadoRepository.findById(id);

        if (empleado.isEmpty()) {
            throw new NoSuchElementException("No se encontró el empleado con el id: " + id);
        }

        if (empleado.get().getCargo() == Cargo.EMPLEADO){
            throw new IllegalArgumentException("El empleado no tiene permisos para realizar esta acción");

        }

         return webClient.get()
                .uri("/api/clientes")
                .retrieve()
                .bodyToFlux(RespuestaCliente.class) //Mapea la respuesta a RespuestaCliente
                .collectList(); //Obtiene el flujo de elementos de la respuesta

    }
}
