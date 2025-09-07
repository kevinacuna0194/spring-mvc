package com.example.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
// Cargar configuración externa
// @PropertySource("classpath:values.properties")
// @PropertySources({
// @PropertySource("classpath:values.properties"),
// @PropertySource("classpath:override.properties")
// })
// Se pueden cargar múltiples archivos de configuración
// El último archivo tiene mayor prioridad en caso de que existan propiedades con el mismo nombre
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
