package com.example.webapp.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    // Define tus endpoints aquí
    @GetMapping("/details")
    public String details() {
        return "details";
    }
}
