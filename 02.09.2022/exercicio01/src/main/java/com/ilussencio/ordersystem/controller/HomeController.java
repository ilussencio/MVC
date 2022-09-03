package com.ilussencio.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ilussencio.ordersystem.model.Pessoa;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucas Ilussencio da silva");
        pessoa.setIdade(25);
        model.addAttribute("name",pessoa);
        model.addAttribute("idade", pessoa);

        return "index";
    }
    
    
    
}
