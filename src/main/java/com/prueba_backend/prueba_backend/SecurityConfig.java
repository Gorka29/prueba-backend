package com.prueba_backend.prueba_backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Habilitar CORS
                .and()
            .csrf().disable() // Deshabilitar CSRF (necesario en entornos sin formularios)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/test/**").permitAll() // Permitir acceso público a endpoints específicos
                .anyRequest().authenticated() // Requerir autenticación para otros endpoints
            );
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
    
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*"); // Permitir todas las solicitudes temporalmente
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
    
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
