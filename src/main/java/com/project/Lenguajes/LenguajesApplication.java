package com.project.Lenguajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.Lenguajes", "Modelo"})
@EntityScan(basePackages = {"Modelo"})
public class LenguajesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LenguajesApplication.class, args);
    }
}
