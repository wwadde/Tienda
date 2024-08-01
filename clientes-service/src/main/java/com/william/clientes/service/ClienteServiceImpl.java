package com.william.clientes.service;

import com.william.clientes.domain.*;
import com.william.clientes.infra.config.RestTemplateConfig;
import com.william.clientes.infra.errores.ClienteException;
import com.william.clientes.infra.errores.ClienteNoEncontradoException;
import com.william.clientes.infra.errores.PermisosInsuficientesException;
import com.william.clientes.infra.errores.TokenException;
import com.william.clientes.infra.security.JwtService;
import com.william.clientes.repository.ClienteRepository;
import com.william.clientes.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final RestTemplateConfig restTemplate;

    private final ClienteRepository clienteRepository;

    private final UsuarioRepository usuarioRepository;

    private final Function<ClienteEntity, DatosClienteFront> empleadoEntityToDatosEmpleadoFront;
    private final JwtService jwtService;


    @Override
    public List<RespuestaProductos> getListaProductos() throws ClienteNoEncontradoException, PermisosInsuficientesException, ClienteException {


        // Configura el rest template para realizar la petición a la uri localhost:8082/api/productos
        String uri = "http://localhost:8082/api/productos";
        try {

            RespuestaProductos[] respuestaProductos = restTemplate.getRestTemplate().getForObject(uri, RespuestaProductos[].class);
            if (respuestaProductos == null || respuestaProductos.length == 0) {
                throw new ClienteException("No se encontraron productos");
            }

            return Arrays.asList(respuestaProductos);

        } catch (RestClientException e) {
            throw new ClienteException("Error al obtener los productos");
        }

    }

    @Override
    public DatosClienteFront poblarDatosClienteFront(Long usuarioId) throws ClienteNoEncontradoException {
        ClienteEntity clienteEntity = clienteRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new ClienteNoEncontradoException("No se encontró el empleado con el usuarioId: " + usuarioId));

        DatosClienteFront datos = empleadoEntityToDatosEmpleadoFront.apply(clienteEntity);
        datos.setId(usuarioId);
        return datos;
    }

    @Override
    public Boolean validarRol(String token) throws TokenException, ClienteException {
        if (token.isBlank()){
            throw new TokenException("Token vacío/inexistente");
        }

        String username = jwtService.verificarToken(token);
        UsuarioEntity usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ClienteException("Usuario no encontrado"));

        return usuario.getRol() != Rol.DEFAULT;

    }
}
