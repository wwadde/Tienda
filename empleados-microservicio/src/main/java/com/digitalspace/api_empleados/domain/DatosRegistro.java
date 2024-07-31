package com.digitalspace.api_empleados.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DatosRegistro {

    private String username;

    private String password;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

}
