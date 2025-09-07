package com.example.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    // Inyección de propiedades desde properties
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

    @Value("#{${config.valueMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valueMap}.product}")
    private String product;

    @Value("#{${config.valueMap}.price}")
    private String price;

    // Inyección de propiedades desde Environment
    // Autowired inyecta la dependencia automáticamente
    // Environment es una interfaz que proporciona acceso a las propiedades del entorno
    // Se puede usar para acceder a las propiedades definidas en application.properties o en otros archivos de configuración
    // También se puede usar para acceder a variables de entorno del sistema o propiedades del sistema
    @Autowired
    private Environment env;

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
    // @PathVariable puede recibir múltiples parámetros de ruta
    // Se pueden combinar diferentes tipos de datos
    // Si no se envía un valor para alguno de los parámetros, se lanzará una excepción 404
    // En caso de que el nombre no coincida, se puede utilizar el atributo "name" de @PathVariable
    // public Map<String, Object> mix(@PathVariable(name = "product") String product, @PathVariable(name = "id") Integer id)
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        response.put("product", product);
        response.put("id", id);
        return response;
    }

    @PostMapping("/create") // http://localhost:8080/api/path/create
    // RequestBody mapea el cuerpo de la petición al objeto User
    // El cuerpo de la petición debe estar en formato JSON
    // Ejemplo de cuerpo de la petición:
    // {
    //"nombre": "Juan",
    // "apellido": "Pérez",
    // "email": "juan.perez@example.com"
    // }
    // El objeto User debe tener los mismos nombres de atributos que el JSON
    // Si el JSON no tiene un atributo que existe en el objeto User, se asignará el valor por defecto (null, 0, false, etc.)
    // El Content-Type de la petición debe ser application/json
    // Si no se envía un cuerpo en la petición, se lanzará una excepción 400
    // Si el cuerpo de la petición no es un JSON válido, se lanzará una excepción 400
    // Si el JSON no puede ser mapeado al objeto User, se lanzará una excepción 400
    // Si el JSON es válido y puede ser mapeado al objeto User, se devolverá el objeto User con los datos mapeados
    // El objeto User se devolverá en formato JSON
    // Si el proceso es exitoso, se devolverá un código de estado 200 OK
    // Se puede probar el endpoint con Postman o con curl
    // http://localhost:8080/api/path/create
    public User create(@RequestBody User user) { // 
        // Lógica para crear un nuevo usuario
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase());
        user.setEmail(user.getEmail().toUpperCase());
        return user;
    }

    @GetMapping("/values") // http://localhost:8080/api/path/values
    // Inyección de propiedades desde un archivo .properties o .yml
    // Se pueden pasar como atibutos de la clase o directamente en el método usando @Value
    // Si se inyectan como atributos de la clase, se pueden usar en cualquier método
    // Si se inyectan directamente en el método, solo se pueden usar en ese método
    // Se pueden combinar ambas formas de inyección
    // Si la propiedad no existe, se lanzará una excepción al iniciar la aplicación
    // Se puede inyectar el valor de la propiedad "config.message" directamente en el método utilizando @Value en el parámetro del método
    // Si la propiedad no existe, se lanzará una excepción al iniciar la aplicación
    // Si se quiere asignar un valor por defecto en caso de que la propiedad no exista,
    // se puede utilizar el atributo "defaultValue" de @Value
    // public Map<String, Object> getValues(@Value("${config.message:No se encontró la propiedad}") String message) {
    public Map<String, Object> getValues(@Value("${config.message:No se encontró la propiedad}") String message) {

        Map<String, Object> response = new HashMap<>();

        Long password = env.getProperty("config.password", Long.class);

        // Inyección de propiedades desde @Value
        response.put("username", username);
        response.put("message", message);
        response.put("listOfValues", listOfValues);

        // SpEL (Spring Expression Language)
        response.put("valueList", valueList);
        response.put("valueString", valueString);
        response.put("valuesMap", valuesMap);
        response.put("product", product);
        response.put("price", price);

        // Inyección de propiedades desde Environment
        response.put("envUsername", env.getProperty("config.username"));
        response.put("envMessage", env.getProperty("config.message"));
        // response.put("envPassword", Integer.valueOf(env.getProperty("config.password")));
        // response.put("envPassword", env.getProperty("config.password", Long.class));
        response.put("envPassword", password);
        
        return response;
    }
}