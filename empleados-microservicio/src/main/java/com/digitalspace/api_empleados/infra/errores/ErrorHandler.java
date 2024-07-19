package com.digitalspace.api_empleados.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EmpleadoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> clienteNoEncontrado(EmpleadoNoEncontradoException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PermisosInsuficientesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> clienteNoEncontrado(PermisosInsuficientesException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }



}
