package com.william.clientes.domain;


import lombok.Data;

@Data
public class DatosClienteFront {

    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private Rol rol;


}
