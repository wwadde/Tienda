package com.digitalspace.api_empleados.infra;

import com.digitalspace.api_empleados.domain.Cargo;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertarEmpleadosPorDefecto {

    @Autowired
    private EmpleadoRepository empleadoRepositoryRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostConstruct
    public void insertarDatos() {
        // Verificar que la tabla este vacia
        if (usuarioRepository.count() == 0) {
            List<UsuarioEntity> usuariosPorDefecto = List.of(
                    new UsuarioEntity("admin", "admin"),
                    new UsuarioEntity("empleado1", "123456"),
                    new UsuarioEntity("jefe", "123456")

            );
            usuarioRepository.saveAll(usuariosPorDefecto);

            UsuarioEntity usuario = usuarioRepository.findByUsername("admin").get();
            UsuarioEntity usuario2 = usuarioRepository.findByUsername("empleado1").get();
            UsuarioEntity usuario3 = usuarioRepository.findByUsername("jefe").get();

            List<EmpleadoEntity> empleadosPorDefecto = List.of(
                    new EmpleadoEntity("Empleado 1", "Apellido 1", "email1", "123456789", Cargo.ADMINISTRADOR, usuario),
            new EmpleadoEntity("Empleado 2", "Apellido 2", "email2", "123456789", Cargo.EMPLEADO, usuario2),

            new EmpleadoEntity("Empleado 3", "Apellido 3", "email2", "123456789", Cargo.JEFE, usuario3)

            );
            empleadoRepositoryRepository.saveAll(empleadosPorDefecto);
        }

    }
}
