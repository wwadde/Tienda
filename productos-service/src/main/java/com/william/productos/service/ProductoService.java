package com.william.productos.service;

import com.william.productos.domain.ProductoDto;
import com.william.productos.infra.erorres.ProductoException;

import java.util.List;

public interface ProductoService {


    List<ProductoDto> listarProductos();

    ProductoDto getProductoById(Long id) throws ProductoException;
}
