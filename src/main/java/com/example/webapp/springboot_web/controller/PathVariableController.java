package com.example.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/path")
public class PathVariableController {

    @GetMapping("/string/{message}") // http://localhost:8080/api/path/string/hola
    // Este método recibe un parámetro de ruta llamado "message"
    // Se utiliza @PathVariable para acceder al valor del parámetro en la URL
    // Por convención, se debería utilizar el mismo nombre en el método y en la URL
    // En caso de que el nombre no coincida, se puede utilizar el atributo "name" de @PathVariable
    // Si no se envía un valor para el parámetro, se lanzará una excepción 404
    public ParamDto paramDto(@PathVariable() String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}") // http://localhost:8080/api/path/mix/telefono/123
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        response.put("product", product);
        response.put("id", id);
        return response;
    }
}
