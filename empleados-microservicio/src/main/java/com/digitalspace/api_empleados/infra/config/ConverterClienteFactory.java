package com.digitalspace.api_empleados.infra.config;


import com.digitalspace.api_empleados.domain.DatosEmpleadoFront;
import com.digitalspace.api_empleados.domain.DatosRegistro;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
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
    public Function<DatosRegistro, EmpleadoEntity> dtoToEmpleadoEntity(ModelMapper mapper){
        return dto -> mapper.map(dto, EmpleadoEntity.class);
    }

    @Bean
    public Function<EmpleadoEntity, DatosEmpleadoFront> empleadoEntityToDatosEmpleadoFront(ModelMapper mapper){
        return empleadoEntity -> mapper.map(empleadoEntity, DatosEmpleadoFront.class);
    }

}
