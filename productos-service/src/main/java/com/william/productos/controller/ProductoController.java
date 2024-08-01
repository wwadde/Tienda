package com.william.productos.controller;

import com.william.productos.domain.ProductoDto;
import com.william.productos.infra.erorres.ProductoException;
import com.william.productos.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable Long id) throws ProductoException {
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> getAllClientes(){
        return ResponseEntity.ok(productoService.listarProductos());
    }


}