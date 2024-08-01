package com.william.productos;


import com.william.productos.domain.ProductoDto;
import com.william.productos.domain.ProductoEntity;
import com.william.productos.repository.ProductoRepository;
import com.william.productos.service.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductoServiceImplTest {


    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @MockBean
    private ProductoRepository productoRepository;

    @Test
    public void testListarProductos() {

        List<ProductoEntity> listaProductos = new ArrayList<>();
        ProductoEntity cliente = new ProductoEntity();
        listaProductos.add(cliente);

        // Configurar el mock
        when(productoRepository.findAll()).thenReturn(listaProductos);

        List<ProductoDto> resultado = productoServiceImpl.listarProductos();

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());

        // Verificar las interacciones con el mock
        verify(productoRepository, times(1)).findAll();
    }
}
