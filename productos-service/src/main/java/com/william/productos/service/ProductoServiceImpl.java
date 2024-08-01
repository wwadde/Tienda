package com.william.productos.service;

import com.william.productos.domain.ProductoDto;
import com.william.productos.domain.ProductoEntity;
import com.william.productos.infra.erorres.ProductoException;
import com.william.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {



    private final ProductoRepository productoRepository;

    private final Function<ProductoEntity, ProductoDto> entityToClienteDatosDto;

    private final Function<ProductoDto, ProductoEntity> dtoToClienteEntity;

    public ProductoServiceImpl(ProductoRepository productoRepository,
                               Function<ProductoEntity, ProductoDto> entityToClienteDatosDto,
                               Function<ProductoDto, ProductoEntity> dtoToClienteEntity) {

        this.productoRepository = productoRepository;
        this.entityToClienteDatosDto = entityToClienteDatosDto;
        this.dtoToClienteEntity = dtoToClienteEntity;
    }

    @Override
    public List<ProductoDto> listarProductos(){

        List<ProductoEntity> clientes = productoRepository.findAll();
        return clientes.stream().map(entityToClienteDatosDto).collect(Collectors.toList());
    }

    @Override
    public ProductoDto getProductoById(Long id) throws ProductoException {
        Optional<ProductoEntity> cliente = productoRepository.findById(id);
        if (cliente.isEmpty()){
            throw new ProductoException("Cliente no encontrado");
        }
        return entityToClienteDatosDto.apply(cliente.get());

    }
}
