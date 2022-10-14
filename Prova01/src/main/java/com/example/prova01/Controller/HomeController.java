package com.example.prova01.Controller;

import com.example.prova01.Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping
    public String produtos(Model model){
        List<Product> listadeprodutos = new ArrayList<>();
        listadeprodutos.add(new Product("Produto 01", 13, new Date(System.currentTimeMillis())));
        listadeprodutos.add(new Product("Produto 02", 14, new Date(System.currentTimeMillis())));
        listadeprodutos.add(new Product("Produto 03", 15, new Date(System.currentTimeMillis())));
        listadeprodutos.add(new Product("Produto 04", 16, new Date(System.currentTimeMillis())));
        model.addAttribute("listadeprodutos", listadeprodutos);
        return "listaDeProdutos";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
