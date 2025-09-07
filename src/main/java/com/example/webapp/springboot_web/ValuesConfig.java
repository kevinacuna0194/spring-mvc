package com.example.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// Clase de configuración para cargar propiedades desde un archivo externo
// Se utiliza @Configuration para indicar que es una clase de configuración
// Se utiliza @PropertySource para indicar el archivo de propiedades a cargar
// Se puede especificar la codificación del archivo con el atributo "encoding"
@Configuration
@PropertySources({
        @PropertySource(value = "classpath:values.properties", encoding = "UTF-8")
})
public class ValuesConfig {
    
}
