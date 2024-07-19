package com.digitalspace.api_clientes.domain;

import lombok.Data;

@Data
public class ClienteDatosDto{

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
