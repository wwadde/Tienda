package com.william.clientes.infra;

import com.william.clientes.domain.Rol;
import com.william.clientes.domain.ClienteEntity;
import com.william.clientes.domain.UsuarioEntity;
import com.william.clientes.repository.ClienteRepository;
import com.william.clientes.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertarClientesPorDefecto {


    private final ClienteRepository clienteRepositoryRepository;

    private final UsuarioRepository usuarioRepository;

    public InsertarClientesPorDefecto(ClienteRepository clienteRepositoryRepository, UsuarioRepository usuarioRepository) {
        this.clienteRepositoryRepository = clienteRepositoryRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @PostConstruct
    public void insertarDatos() {
        // Verificar que la tabla este vacia
        if (usuarioRepository.count() == 0) {
            List<UsuarioEntity> usuariosPorDefecto = List.of(
                    new UsuarioEntity("admin", "$2a$10$xQtImqk59K9qzbjBVUa1jugGL7DKIEWF.y58oA.ky3iQLJBg5rYxi", Rol.ADMINISTRADOR), // admin
                    new UsuarioEntity("empleado1", "$2a$10$LdkOQHyotBY/nPGe1v77R.a8/1OfV2Oy8PQcJWK7NsZg2ra3en7V6", Rol.DEFAULT), //123456
                    new UsuarioEntity("jefe", "$2a$10$LdkOQHyotBY/nPGe1v77R.a8/1OfV2Oy8PQcJWK7NsZg2ra3en7V6", Rol.DEFAULT) // 123456

            );
            usuarioRepository.saveAll(usuariosPorDefecto);

            UsuarioEntity usuario = usuarioRepository.findByUsername("admin").get();
            UsuarioEntity usuario2 = usuarioRepository.findByUsername("empleado1").get();
            UsuarioEntity usuario3 = usuarioRepository.findByUsername("jefe").get();

            List<ClienteEntity> empleadosPorDefecto = List.of(
                    new ClienteEntity("Empleado 1", "Apellido 1", "email1", "123456789", usuario),
            new ClienteEntity("Empleado 2", "Apellido 2", "email2", "123456789", usuario2),

            new ClienteEntity("Empleado 3", "Apellido 3", "email2", "123456789", usuario3)

            );
            clienteRepositoryRepository.saveAll(empleadosPorDefecto);
        }

    }
}
