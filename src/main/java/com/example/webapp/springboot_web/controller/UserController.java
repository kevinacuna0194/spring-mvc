package com.example.webapp.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    // Define tus endpoints aquí
    @GetMapping("/details")
    public String details(Model model) {

        model.addAttribute("title", "Detalles del Usuario");
        model.addAttribute("description", "Aquí están los detalles del usuario.");
        model.addAttribute("userId", 1);
        model.addAttribute("userName", "Juan Pérez");
        model.addAttribute("userEmail", "juan.perez@example.com");
        return "details";
    }
}
