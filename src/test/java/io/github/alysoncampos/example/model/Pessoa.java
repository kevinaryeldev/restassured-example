package io.github.alysoncampos.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String nome, String dataNascimento, String cpf, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
    }
}
