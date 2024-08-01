package com.william.clientes.controller;

import com.william.clientes.domain.RespuestaProductos;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;
import com.william.clientes.infra.errores.PermisosInsuficientesException;
import com.william.clientes.infra.errores.TokenException;
import com.william.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;


    @GetMapping()
    public ResponseEntity<List<RespuestaProductos>> getProductos(@RequestHeader("Authorization") String token)
            throws PermisosInsuficientesException,
            ClienteNoEncontradoException, ClienteException, TokenException {

        // Remueve el Bearer del token
        Boolean tienePermisos = clienteService.validarRol(token.substring(7));


        if (Boolean.TRUE.equals(tienePermisos)) {
            List<RespuestaProductos> listaClientes = clienteService.getListaProductos();
            return ResponseEntity.ok(listaClientes);
        } else {
            throw new PermisosInsuficientesException("El empleado no tiene permisos para realizar esta acción");
        }

    }
}
