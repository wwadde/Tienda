package com.william.productos.domain;

import lombok.Getter;

@Getter
public enum Categoria {

    ELECTRONICA("Electrónica"),
    MUEBLES("Muebles"),
    ROPA("Ropa"),
    CALZADO("Calzado"),
    HERRAMIENTAS("Herramientas"),
    JUGUETES("Juguetes"),
    LIBROS("Libros"),
    OTROS("Otros");

    private final String descripcion;

    Categoria(String descripcion) {
        this.descripcion = descripcion;
    }


}
