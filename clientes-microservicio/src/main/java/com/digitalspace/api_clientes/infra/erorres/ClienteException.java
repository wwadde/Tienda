package com.digitalspace.api_clientes.infra.erorres;

public class ClienteException extends Exception {

    public ClienteException(String mensaje) {
        super(mensaje);
    }
}
