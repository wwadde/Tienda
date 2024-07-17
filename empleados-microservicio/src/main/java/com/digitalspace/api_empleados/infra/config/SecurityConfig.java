package com.digitalspace.api_empleados.infra.config;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//
//import java.net.URI;
//
////@Configuration
////@EnableReactiveMethodSecurity
////public class SecurityConfig {
////
////    @Bean
////    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
////        http.csrf(csrf -> csrf.disable())
////        .authorizeExchange(exchanges -> exchanges
////                        .pathMatchers("/").permitAll() // Permite acceso a la página del login
////                        .anyExchange().authenticated() // Requiere autenticación para cualquier otra solicitud
////                )
////                .formLogin(formLogin -> formLogin
////                        .loginPage("/") // Usar la vista de mi login
////                        .authenticationSuccessHandler((webFilterExchange, authentication) -> {
////                            webFilterExchange.getExchange().getResponse().setStatusCode(HttpStatus.FOUND);
////                            webFilterExchange.getExchange().getResponse().getHeaders().setLocation(URI.create("/dashboard")); // Redireccion luego de login exitoso
////                            return webFilterExchange.getExchange().getResponse().setComplete();
////                        })
////                );
////        return http.build();
////    }
////}
