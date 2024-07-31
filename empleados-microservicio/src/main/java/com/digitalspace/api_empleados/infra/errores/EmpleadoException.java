package com.digitalspace.api_empleados.infra.errores;

public class EmpleadoException extends Exception{

    public EmpleadoException(String message) {
        super(message);
    }

    public EmpleadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
