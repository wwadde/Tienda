package com.william.clientes.infra.errores;

public class TokenException extends RuntimeException {
    public TokenException(String mensaje) {
        super(mensaje);
    }
}
