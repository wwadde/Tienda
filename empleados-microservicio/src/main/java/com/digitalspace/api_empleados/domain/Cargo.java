package com.digitalspace.api_empleados.domain;

import lombok.Getter;

@Getter
public enum Cargo {
    JEFE("Jefe"),
    ADMINISTRADOR("Administrador"),
    EMPLEADO("Empleado");

    private final String descripcion;

    Cargo(String descripcion) {
        this.descripcion = descripcion;
    }

}
