package com.digitalspace.api_clientes;


import com.digitalspace.api_clientes.domain.ClienteDatosDto;
import com.digitalspace.api_clientes.domain.ClienteEntity;
import com.digitalspace.api_clientes.repository.ClienteRepository;
import com.digitalspace.api_clientes.service.ClienteService;
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
public class ClienteServiceTest {


    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testListarClientes() {

        List<ClienteEntity> listaClientes = new ArrayList<>();
        ClienteEntity cliente = new ClienteEntity();
        listaClientes.add(cliente);

        // Configurar el mock
        when(clienteRepository.findAll()).thenReturn(listaClientes);

        List<ClienteDatosDto> resultado = clienteService.listarClientes();

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());

        // Verificar las interacciones con el mock
        verify(clienteRepository, times(1)).findAll();
    }
}
