package com.example.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.springboot_web.models.User;
import com.example.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/path")
public class PathVariableController {

    // Inyección de propiedades desde application.properties
    @Value("${config.username}")
    private String username;

    // @Value("${config.message}")
    // private String message;

    @Value("${config.listOfValues}")
    // private String[] listOfValues;
    private List<String> listOfValues;

    // SpEL (Spring Expression Language)
    // Se utiliza para evaluar expresiones en tiempo de ejecución
    // En este caso, se utiliza para dividir una cadena en una lista
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @GetMapping("/string/{message}") // http://localhost:8080/api/path/string/hola
    // Este método recibe un parámetro de ruta llamado "message"
    // Se utiliza @PathVariable para acceder al valor del parámetro en la URL
    // Por convención, se debería utilizar el mismo nombre en el método y en la URL
    // En caso de que el nombre no coincida, se puede utilizar el atributo "name" de
    // @PathVariable
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

    @PostMapping("/create") // http://localhost:8080/api/path/create
    public User create(@RequestBody User user) {
        // Lógica para crear un nuevo usuario
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        return user;
    }

    @GetMapping("/values") // http://localhost:8080/api/path/values
    // Se puede inyectar el valor de la propiedad "config.message" directamente en
    // el método
    public Map<String, Object> getValues(@Value("${config.message}") String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("message", message);
        response.put("listOfValues", listOfValues);
        response.put("valueList", valueList);
        response.put("valueString", valueString);
        return response;
    }
}