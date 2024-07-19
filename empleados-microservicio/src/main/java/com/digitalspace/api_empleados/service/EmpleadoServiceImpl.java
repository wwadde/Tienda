package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.Cargo;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.RespuestaCliente;
import com.digitalspace.api_empleados.infra.config.RestTemplateConfig;
import com.digitalspace.api_empleados.infra.errores.ClienteException;
import com.digitalspace.api_empleados.infra.errores.EmpleadoNoEncontradoException;
import com.digitalspace.api_empleados.infra.errores.PermisosInsuficientesException;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {


    private final RestTemplateConfig restTemplate;

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(RestTemplateConfig restTemplate, EmpleadoRepository empleadoRepository) {
        this.restTemplate = restTemplate;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<RespuestaCliente> getListaClientes(Long id) throws EmpleadoNoEncontradoException, PermisosInsuficientesException, ClienteException {

        Optional<EmpleadoEntity> empleado = empleadoRepository.findById(id);

        if (empleado.isEmpty()) {
            throw new EmpleadoNoEncontradoException("No se encontró el empleado con el id: " + id);
        }
        if (empleado.get().getCargo() == Cargo.EMPLEADO) {
            throw new PermisosInsuficientesException("El empleado no tiene permisos para realizar esta acción");
        }

        // Configura el rest template para realizar la petición a la uri localhost:8082/api/clientes
        String uri = "http://localhost:8082/api/clientes";
        try {

            RespuestaCliente[] respuestaClientes = restTemplate.getRestTemplate().getForObject(uri, RespuestaCliente[].class);
            if (respuestaClientes == null || respuestaClientes.length == 0) {
                throw new ClienteException("No se encontraron clientes");
            }

            return Arrays.asList(respuestaClientes);

        } catch (RestClientException e) {
            throw new ClienteException("Error al obtener los clientes");
        }

    }
}
