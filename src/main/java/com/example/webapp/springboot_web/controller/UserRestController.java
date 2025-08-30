package com.example.webapp.springboot_web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.springboot_web.models.User;
import com.example.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api/users") // Endpoint base para usuarios
public class UserRestController {

    // Define tus endpoints aquí
    @GetMapping("/details") // Endpoint para obtener detalles del usuario
    public UserDto Details() {
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setTitle("Detalles del Usuario");
        userDto.setDescription("Aquí están los detalles del usuario.");
        User user = new User("Juan Pérez", "juan.perez@example.com");
        userDto.setUser(user);

        return userDto;
    }

    @GetMapping("/list")
    public List<User> listAll() {
        User user = new User("Juan Pérez", "juan.perez@example.com");
        User user2 = new User("María López", "maria.lopez@example.com");
        User user3 = new User("Pedro González", "pedro.gonzalez@example.com");

        List<User> users = Arrays.asList(user, user2, user3);

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);
        
        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> details() {

        User user = new User("Juan Pérez", "juan.perez@example.com");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Detalles del Usuario");
        body.put("description", "Aquí están los detalles del usuario.");
        body.put("userId", 1);
        // body.put("userName", "Juan Pérez");
        // body.put("userEmail", "juan.perez@example.com");
        // body.put("userName", user.getName());
        // body.put("userEmail", user.getEmail());
        body.put("user", user);
        return body;
    }
}
