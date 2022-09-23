package com.ilussencio.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

    @RequestMapping("/")
    public String init(){
        return "Ola, mundo!";
    }

    @RequestMapping("/home")
    public String home(){
        return "Bem-vindo a pagina HOMEsdf";
    }

}
