package com.stevecoder.tienda_moda_API.common.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// Buena practica separar la configuracion y no hacerlo en el fichero general
@Configuration // spring boot inicia la app y escanea el proyecto para iniciarlo con esta configuracion
@EnableAsync // Se habilita el async
@EnableScheduling
@EnableCaching
public class ApplicationConfig {
}
