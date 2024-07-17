package com.digitalspace.api_empleados.domain;

import lombok.Data;

@Data
public class RespuestaCliente {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
