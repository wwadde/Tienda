package com.william.clientes.infra.errores;

public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}
