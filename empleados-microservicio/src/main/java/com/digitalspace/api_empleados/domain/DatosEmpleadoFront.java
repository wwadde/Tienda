package com.digitalspace.api_empleados.domain;


import lombok.Data;

@Data
public class DatosEmpleadoFront {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private Cargo cargo;


}
