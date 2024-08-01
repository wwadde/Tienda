package com.william.productos.domain;

import lombok.Data;

@Data
public class ProductoDto {

    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Categoria categoria;
}
