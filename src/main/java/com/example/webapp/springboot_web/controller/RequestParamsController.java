package com.example.webapp.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params") // <--- Aquí se define la ruta base para este controlador
public class RequestParamsController {

    @GetMapping("/string") // http://localhost:8080/api/params/string?message=hola
    // Espera recibir un parámetro llamado "message". Es obligatorio. Default
    // required = true.
    // Si @RequestParam tiene required = false, el parámetro es opcional.
    // Si se utiliza name = "mensaje ", se espera que el parámetro en la URL se
    // llame "mensaje". De lo contrario, toma el nombre del parámetro en el método.
    // Por convencion se debería utilizar el mismo nombre en el método y en la URL.
    public ParamDto paramDto(
            @RequestParam(required = false, defaultValue = "No se recibió ningún mensaje") String message) {
        ParamDto paramDto = new ParamDto();
        // paramDto.setMessage(message != null ? message : "No se recibió ningún
        // mensaje");
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/string-v2") // http://localhost:8080/api/params/string-v2?text=hola&number=123
    public ParamDto paramDtoV2(@RequestParam String text, @RequestParam Integer number) {
        ParamDto paramDto = new ParamDto();

        paramDto.setMessage(text);
        paramDto.setNumber(number);

        return paramDto;
    }

    @GetMapping("/request")
    // http://localhost:8080/api/params/request?number=123&message=hola
    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public ParamDto request(HttpServletRequest request) {
        Integer number = 0;

        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
        }

        ParamDto paramDto = new ParamDto();

        paramDto.setNumber(number);
        paramDto.setMessage(request.getParameter("message"));

        return paramDto;
    }
}