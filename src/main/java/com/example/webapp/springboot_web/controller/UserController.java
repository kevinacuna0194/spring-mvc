package com.example.webapp.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.webapp.springboot_web.models.User;

@Controller
public class UserController {

    // Define tus endpoints aquí
    @GetMapping("/details")
    public String details(Model model) {
        
        User user = new User("Juan Pérez", "juan.perez@example.com");

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
}
