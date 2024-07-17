package com.digitalspace.api_clientes.domain;

public record ClienteDatosDto(
        String id,

        String nombre,

        String apellido,

        String email,

        String telefono,

        String direccion
) {

    public ClienteDatosDto(ClienteEntity cliente){
        this(cliente.getId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(), cliente.getTelefono(),
                cliente.getDireccion());
    }

}
