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
    
        // Configurar CORS
        config.setAllowCredentials(true);
        config.addAllowedOrigin("https://davidperezfisioterapia.vercel.app");
        config.addAllowedOrigin("http://localhost:4200");
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
