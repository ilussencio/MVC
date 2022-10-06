package br.com.ilussencio.crud_disciplinas.controller;

import br.com.ilussencio.crud_disciplinas.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping
    public String principal(){
        return "home";
    }

    @GetMapping("/contatos")
    public String contatos(Model model){
        List <Contato> listaDeContatos = jdbcTemplate.query(
                "select * from contatoS",
                (res, rowNum) -> {
                    Contato contato = new Contato(
                        res.getInt("id"),
                        res.getString("nome"),
                        res.getString("telefone"),
                        res.getString("endereco"));
                    return contato;
                });
        model.addAttribute("contatos", listaDeContatos);
        return "contatos";
    }

    @GetMapping("/novo")
    public String exibeForm(Model model){
        model.addAttribute("contato", new Contato());
        return "formulario";
    }

    @PostMapping("/novo")
    public String gravaDados(Contato contato){
        System.out.println(contato);
        return "home";
    }
}
