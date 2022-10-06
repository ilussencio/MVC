package br.com.ilussencio.crud_disciplinas.controller;

import br.com.ilussencio.crud_disciplinas.model.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        List<Contato> listaDeContatos = jdbcTemplate.query("SELECT id, nome, telefone FROM contatos", (rs, rowNum) -> {
            return new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"));
        });
        model.addAttribute("contatos", listaDeContatos);
        return "contatos";
    }
}
