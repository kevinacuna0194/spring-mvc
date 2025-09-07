package com.example.webapp.springboot_web.controller;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.webapp.springboot_web.models.User;

@Controller
public class UserController {

    // Define tus endpoints aquí
    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Juan", "Pérez", "juan.perez@example.com");

        model.addAttribute("title", "Detalles del Usuario");
        model.addAttribute("description", "Aquí están los detalles del usuario.");
        model.addAttribute("userId", 1);
        // model.addAttribute("userName", "Juan Pérez");
        // model.addAttribute("userEmail", "juan.perez@example.com");
        // model.addAttribute("userName", user.getName());
        // model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String listAll(ModelMap model) {

        // List<User> users = new ArrayList<>();
        // users.add(new User("Juan", "Pérez", "juan.perez@example.com"));
        // users.add(new User("María", "Gómez", "maria.gomez@example.com"));
        // users.add(new User("Pedro", "López", null));

        // List<User> users = Arrays.asList(
        //     new User("Juan", "Pérez", "juan.perez@example.com"),
        //     new User("María", "Gómez", "maria.gomez@example.com"),
        //     new User("Pedro", "López", null),
        //     new User("Ana", "Martínez", "ana.martinez@example.com")
        // );

        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("description", "Aquí está la lista de usuarios.");
        // model.addAttribute("users", users);

        return "list";
    }

    // Método para poblar la lista de usuarios. Es global para todos los métodos del controlador.
    // Se puede usar en cualquier vista que se renderice desde este controlador.
    @ModelAttribute("users")
    public List<User> populateUsers() {
        return Arrays.asList(
            new User("Juan", "Pérez", "juan.perez@example.com"),
            new User("María", "Gómez", "maria.gomez@example.com"),
            new User("Pedro", "López", null),
            new User("Ana", "Martínez", "ana.martinez@example.com")
        );
    }
}