package com.digitalspace.api_empleados.infra.errores;

public class EmpleadoNoEncontradoException extends Exception {
    public EmpleadoNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}
