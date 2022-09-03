package com.ilussencio.exercicio05.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MegaController {
    @RequestMapping("mega")
    public String requestMethodName(Model modelo) {
        Random random = new Random();
        List<Integer> array = new ArrayList<>();
        for(int i = 1; i <= 60; i ++)
            array.add(i);
        modelo.addAttribute("numero1",array.remove(random.nextInt(0,array.size())));
        modelo.addAttribute("numero2",array.remove(random.nextInt(0,array.size())));
        modelo.addAttribute("numero3",array.remove(random.nextInt(0,array.size())));
        modelo.addAttribute("numero4",array.remove(random.nextInt(0,array.size())));
        modelo.addAttribute("numero5",array.remove(random.nextInt(0,array.size())));
        modelo.addAttribute("numero6",array.remove(random.nextInt(0,array.size())));
        return "megasena";
    }
    
}
