package com.digitalspace.api_clientes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "clientes")
@Data
@NoArgsConstructor
public class ClienteEntity {

    @Id
    private String id;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String direccion;

    public ClienteEntity(String nombre, String apellido, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }
}
