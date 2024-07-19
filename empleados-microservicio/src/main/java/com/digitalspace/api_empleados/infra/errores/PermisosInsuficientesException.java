package com.digitalspace.api_empleados.infra.errores;

public class PermisosInsuficientesException extends Exception {
    public PermisosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}
