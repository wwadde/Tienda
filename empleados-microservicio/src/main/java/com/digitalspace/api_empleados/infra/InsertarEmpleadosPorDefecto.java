package com.digitalspace.api_empleados.infra;

import com.digitalspace.api_empleados.domain.Cargo;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertarEmpleadosPorDefecto {


    private final EmpleadoRepository empleadoRepositoryRepository;

    private final UsuarioRepository usuarioRepository;

    public InsertarEmpleadosPorDefecto(EmpleadoRepository empleadoRepositoryRepository, UsuarioRepository usuarioRepository) {
        this.empleadoRepositoryRepository = empleadoRepositoryRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @PostConstruct
    public void insertarDatos() {
        // Verificar que la tabla este vacia
        if (usuarioRepository.count() == 0) {
            List<UsuarioEntity> usuariosPorDefecto = List.of(
                    new UsuarioEntity("admin", "$2a$10$xQtImqk59K9qzbjBVUa1jugGL7DKIEWF.y58oA.ky3iQLJBg5rYxi", Cargo.ADMINISTRADOR), // admin
                    new UsuarioEntity("empleado1", "$2a$10$LdkOQHyotBY/nPGe1v77R.a8/1OfV2Oy8PQcJWK7NsZg2ra3en7V6", Cargo.EMPLEADO), //123456
                    new UsuarioEntity("jefe", "$2a$10$LdkOQHyotBY/nPGe1v77R.a8/1OfV2Oy8PQcJWK7NsZg2ra3en7V6", Cargo.JEFE) // 123456

            );
            usuarioRepository.saveAll(usuariosPorDefecto);

            UsuarioEntity usuario = usuarioRepository.findByUsername("admin").get();
            UsuarioEntity usuario2 = usuarioRepository.findByUsername("empleado1").get();
            UsuarioEntity usuario3 = usuarioRepository.findByUsername("jefe").get();

            List<EmpleadoEntity> empleadosPorDefecto = List.of(
                    new EmpleadoEntity("Empleado 1", "Apellido 1", "email1", "123456789", usuario),
            new EmpleadoEntity("Empleado 2", "Apellido 2", "email2", "123456789", usuario2),

            new EmpleadoEntity("Empleado 3", "Apellido 3", "email2", "123456789", usuario3)

            );
            empleadoRepositoryRepository.saveAll(empleadosPorDefecto);
        }

    }
}
