package com.william.clientes.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ClienteNoEncontradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> clienteNoEncontrado(ClienteNoEncontradoException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(PermisosInsuficientesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> clienteNoEncontrado(PermisosInsuficientesException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ClienteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> clienteExistente(ClienteException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(TokenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> errorToken(TokenException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
