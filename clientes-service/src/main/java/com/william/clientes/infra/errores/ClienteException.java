package com.william.clientes.infra.errores;

public class ClienteException extends Exception {

    public ClienteException(String mensaje) {
        super(mensaje);
    }

    public ClienteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
