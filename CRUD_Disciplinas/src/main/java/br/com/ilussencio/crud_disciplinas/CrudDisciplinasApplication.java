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
        jdbcTemplate.execute("CREATE TABLE contatos(id SERIAL, nome VARCHAR(50), telefone VARCHAR(50), endereco VARCHAR(50) )");

        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)", "Edson Angoti Júnior", "123456","RUA 1");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)", "José Joaquim", "123","RUA 1");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)", "Maria Carolina", "123","RUA 1");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone, endereco) VALUES (?,?,?)","Lucas Ilussencio da Silva", "12345","RUA 1");

    }
}
