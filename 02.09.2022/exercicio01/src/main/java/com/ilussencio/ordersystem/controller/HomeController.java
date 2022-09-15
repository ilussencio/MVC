package com.ilussencio.ordersystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ilussencio.ordersystem.model.Pessoa;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model ) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Lucas Ilussencio da silva");
        pessoa.setIdade(25);
        model.addAttribute("p",pessoa);
        return "index";
    }

    @GetMapping("home/{nome}")
    public String homeP(Model model, @PathVariable String nome){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        model.addAttribute("p",pessoa);
        return "index";
    }
    
    
    
}
