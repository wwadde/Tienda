package com.william.clientes.infra.config;


import com.william.clientes.domain.DatosClienteFront;
import com.william.clientes.domain.DatosRegistro;
import com.william.clientes.domain.ClienteEntity;
import com.william.clientes.domain.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ConverterClienteFactory {

    @Bean
    public Function<DatosRegistro, UsuarioEntity> dtoToUsuarioEntity(ModelMapper mapper){
        return dto -> mapper.map(dto, UsuarioEntity.class);
    }

    @Bean
    public Function<DatosRegistro, ClienteEntity> dtoToEmpleadoEntity(ModelMapper mapper){
        return dto -> mapper.map(dto, ClienteEntity.class);
    }

    @Bean
    public Function<ClienteEntity, DatosClienteFront> empleadoEntityToDatosEmpleadoFront(ModelMapper mapper){
        return empleadoEntity -> mapper.map(empleadoEntity, DatosClienteFront.class);
    }

}
