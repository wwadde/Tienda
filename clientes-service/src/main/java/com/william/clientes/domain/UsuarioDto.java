package com.william.clientes.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {

    private String username;
    private String password;

}
