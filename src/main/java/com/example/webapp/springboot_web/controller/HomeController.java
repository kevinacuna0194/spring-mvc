package com.example.webapp.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"}) // http://localhost:8080/
    public String home() {
        // Redirect cambia la URL en el navegador, reiniciando la petición y refrescando la página.
        return "redirect:/list";
        // Forward se mantiene dentro de la misma petición http.
        // Se utiliza cuando se quiere pasar el control a otro controlador sin cambiar la URL.
        // return "forward:/list";
    }
}
