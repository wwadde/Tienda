package com.william.clientes.infra.errores;

public class PermisosInsuficientesException extends Exception {
    public PermisosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}
