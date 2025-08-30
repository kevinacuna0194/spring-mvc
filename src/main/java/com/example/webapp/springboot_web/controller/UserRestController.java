package com.example.webapp.springboot_web.controller;

// import java.util.HashMap;
// import java.util.Map;

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

    /*
     * @GetMapping("/details")
     * public Map<String, Object> details() {
     * 
     * User user = new User("Juan Pérez", "juan.perez@example.com");
     * 
     * Map<String, Object> body = new HashMap<>();
     * 
     * body.put("title", "Detalles del Usuario");
     * body.put("description", "Aquí están los detalles del usuario.");
     * body.put("userId", 1);
     * // body.put("userName", "Juan Pérez");
     * // body.put("userEmail", "juan.perez@example.com");
     * // body.put("userName", user.getName());
     * // body.put("userEmail", user.getEmail());
     * body.put("user", user);
     * return body;
     * }
     */
}
