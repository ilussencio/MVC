package br.com.ilussencio.crud_disciplinas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudDisciplinasApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(CrudDisciplinasApplication.class, args);
    }
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("DROP TABLE contatos IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE contatos(id SERIAL, nome VARCHAR(255), telefone VARCHAR(255) )");

        jdbcTemplate.update("INSERT INTO contatos(nome,telefone) VALUES (?,?)", "Edson Angoti Júnior", "123456");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone) VALUES (?,?)", "José Joaquim", "123");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone) VALUES (?,?)", "Maria Carolina", "123");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone) VALUES (?,?)","Lucas Ilussencio da Silva", "12345");

    }
}
