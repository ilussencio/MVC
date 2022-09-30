package br.edu.iftm.jdbctemplate;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class JdbctemplateApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbctemplateApplication.class, args);
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

		List<Contato> contatos = jdbcTemplate.query("SELECT id, nome, telefone FROM contatos", (rs, rowNum) -> {
			return new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("telefone"));
		});

		System.out.println("Listando contatos");
		for (Contato contato : contatos) {
			System.out.println(contato.getId()+" - "+ contato.getNome() + " - " + contato.getTelefone());
		}

		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from contatos", Integer.class);
		System.out.println("Numero de contatos registrados: "+rowCount);

		String contato = this.jdbcTemplate.queryForObject(
				"select telefone from contatos where nome = ?",
				String.class, "Edson Angoti Júnior"
		);
		System.out.println("Numero de contato de Edson Angoti: "+contato);
	}
}
