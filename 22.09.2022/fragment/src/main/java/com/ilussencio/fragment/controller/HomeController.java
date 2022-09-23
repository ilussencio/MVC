package com.ilussencio.fragment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("pagina01")
    public String pagina01 (){
        return "pagina01";
    }

    @GetMapping("pagina02")
    public String pagina02 (){
        return "pagina02";
    }
    
}
