package com.prueba_backend.prueba_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().anyRequest().permitAll() // Permitir acceso a todos los endpoints sin autenticación
            .and().csrf().disable(); // Deshabilitar protección CSRF si es necesario
        return http.build();
    }
}
