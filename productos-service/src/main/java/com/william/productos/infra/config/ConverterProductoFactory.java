package com.william.productos.infra.config;

import com.william.productos.domain.ProductoDto;
import com.william.productos.domain.ProductoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ConverterProductoFactory {

    @Bean
    public Function<ProductoEntity, ProductoDto> entityToClienteDatosDto(ModelMapper mapper){
        return entity -> mapper.map(entity, ProductoDto.class);
    }

    @Bean
    public Function<ProductoDto, ProductoEntity> dtoToClienteEntity(ModelMapper mapper){
        return dto -> mapper.map(dto, ProductoEntity.class);
    }

}
