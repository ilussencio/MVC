package br.com.ilussencio.crud_disciplinas.model;

import lombok.Data;

@Data
public class Contato {
    int id;
    String nome, telefone, endereco;

    public Contato(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
