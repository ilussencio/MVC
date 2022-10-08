package sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import sistema.model.Professor;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate db;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/professor")
    public String professores(Model model) {
        List<Professor> listaDeProfessor = db.query(
                "select * from professores",
                (res, rowNum) -> {
                    Professor prof = new Professor(
                            res.getInt("id"),
                            res.getString("nome"));
                    return prof;
                });
        model.addAttribute("professor", listaDeProfessor);
        return "professor";
    }

    @GetMapping("novo")
    public String exibeForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "formulario";
    }

    @PostMapping("novo")
    public String gravaDados(Professor prof) {
        db.update("insert into professores(nome) values (?)",
                prof.getNome());

        return "redirect:/professor";
    }

    @GetMapping("/excluir-professor")
    public String apagarprofessor(@RequestParam(value="id", required = true) Integer cod){
        System.out.println(cod);
        db.update(
                "delete from professores where id = ?",
                cod
        );
        return "redirect:/professor";
    }

    @GetMapping("/editar-professor")
    public String mostraFormAlteraProfessor(@RequestParam(value="id", required = true) Integer cod, Model model){
        Professor prof = db.queryForObject(
                "select * from professores where id = ?",
                (rs, rowNum) -> {
                    Professor p = new Professor();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    return p;
                },
                cod
        );

        model.addAttribute("professor", prof);

        return "form-edita-professor";
    }

    @PostMapping("/editar-professor")
    public String editarProfessor(Professor prof){
        db.update(
                "update professores set nome = ? where id = ?",
                prof.getNome(),
                prof.getId()
        );

        return "redirect:/professor";
    }

}
