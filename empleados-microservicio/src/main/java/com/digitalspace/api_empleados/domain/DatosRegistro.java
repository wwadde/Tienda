package com.digitalspace.api_empleados.domain;

import lombok.Data;

@Data
public class DatosRegistro {

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    // Cargo por defecto
    private Cargo cargo = Cargo.EMPLEADO;
}
