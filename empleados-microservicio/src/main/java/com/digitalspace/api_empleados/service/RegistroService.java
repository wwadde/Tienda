package com.digitalspace.api_empleados.service;

import com.digitalspace.api_empleados.domain.DatosRegistro;
import com.digitalspace.api_empleados.domain.EmpleadoEntity;
import com.digitalspace.api_empleados.domain.UsuarioEntity;
import com.digitalspace.api_empleados.repository.EmpleadoRepository;
import com.digitalspace.api_empleados.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RegistroService {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;
    private final Function<DatosRegistro, UsuarioEntity> dtoToUsuarioEntity;
    private final Function<DatosRegistro, EmpleadoEntity> dtoToEmpleadoEntity;

    public RegistroService(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository, Function<DatosRegistro, UsuarioEntity> dtoToUsuarioEntity, Function<DatosRegistro, EmpleadoEntity> dtoToEmpleadoEntity) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
        this.dtoToUsuarioEntity = dtoToUsuarioEntity;
        this.dtoToEmpleadoEntity = dtoToEmpleadoEntity;
    }


    @Transactional
    public void registrarUsuarioEmpleado(DatosRegistro datos) {

        UsuarioEntity usuario = dtoToUsuarioEntity.apply(datos);
        usuarioRepository.save(usuario);

        EmpleadoEntity empleado = dtoToEmpleadoEntity.apply(datos);
        empleadoRepository.save(empleado);


    }
}

