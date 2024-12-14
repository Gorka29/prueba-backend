package com.prueba_backend.prueba_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:4200") // Habilita CORS para tu frontend
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, the application is running correctly!";
    }

    @GetMapping("/status")
    public String status() {
        return "Application status: UP";
    }

    // Ruta raíz
    @GetMapping("/")
    public String root() {
        return "Welcome to the Spring Boot Application!";
    }
}
