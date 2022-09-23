package com.ilussencio.artefact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping(value="/home")
    public String home() {
        return "home";
    }
    
    @GetMapping(value="/next")
    public String next(){
        return "next";
    }

}
