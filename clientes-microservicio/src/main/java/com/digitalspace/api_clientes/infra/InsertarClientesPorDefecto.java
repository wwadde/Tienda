package com.digitalspace.api_clientes.infra;

import com.digitalspace.api_clientes.domain.ClienteEntity;
import com.digitalspace.api_clientes.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertarClientesPorDefecto {


    private final ClienteRepository clienteRepository;

    public InsertarClientesPorDefecto(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostConstruct
    public void insertarDatos() {
        // Verificar que la tabla este vacia
        if (clienteRepository.count() == 0) {
            List<ClienteEntity> clientesPorDefecto = List.of(
                    new ClienteEntity("William", "Wadde", "williamwadde@gmail.com", "123456789", "Dirección 1"),
                    new ClienteEntity("Juan", "Diaz", "juan@gmail.com", "123456789", "Dirección 2"),
                    new ClienteEntity("Oscar", "Beltran", "oscar@gmail.com", "123456789", "Dirección 3"),
                    new ClienteEntity("David", "Benavidez", "david@gmail.com", "123456789", "Dirección 4"),
                    new ClienteEntity("Brayan", "Agudelo", "brayan@gmail.com", "123456789", "Dirección 5")
            );
            clienteRepository.saveAll(clientesPorDefecto);
        }
    }
}
