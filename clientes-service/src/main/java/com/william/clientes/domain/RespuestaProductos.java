package com.william.clientes.domain;

import lombok.Data;

@Data
public class RespuestaProductos {

    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
}
