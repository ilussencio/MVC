package com.ilussencio.aulabootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("exemplo")
    public String aula(){
        return "home";
    }
}
