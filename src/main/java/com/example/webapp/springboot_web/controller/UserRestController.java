package com.example.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    // Define tus endpoints aquí
    @GetMapping("/details")
    public Map<String, Object> details() {

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Detalles del Usuario");
        body.put("description", "Aquí están los detalles del usuario.");
        body.put("userId", 1);
        body.put("userName", "Juan Pérez");
        body.put("userEmail", "juan.perez@example.com");
        return body;
    }
}
