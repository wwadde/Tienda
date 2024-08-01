package com.william.clientes.domain;

import lombok.Getter;

@Getter
public enum Rol {
    ADMINISTRADOR("Administrador"),
    DEFAULT("Por-defecto");

    private final String descripcion;

    Rol(String descripcion) {
        this.descripcion = descripcion;
    }

}
