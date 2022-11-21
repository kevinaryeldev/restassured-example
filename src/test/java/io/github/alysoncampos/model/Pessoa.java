package io.github.alysoncampos.model;

import lombok.Data;

@Data
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
