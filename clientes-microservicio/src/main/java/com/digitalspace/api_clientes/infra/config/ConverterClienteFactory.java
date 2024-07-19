package com.digitalspace.api_clientes.infra.config;

import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.domain.ClienteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ConverterClienteFactory {

    @Bean
    public Function<ClienteEntity, ClienteDatosDto> entityToClienteDatosDto(ModelMapper mapper){
        return entity -> mapper.map(entity, ClienteDatosDto.class);
    }

    @Bean
    public Function<ClienteDatosDto,ClienteEntity> dtoToClienteEntity(ModelMapper mapper){
        return dto -> mapper.map(dto, ClienteEntity.class);
    }

}
