package io.github.alysoncampos.example.model;

import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;

public class PessoaBuilder {

    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;

    public PessoaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder dataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public PessoaBuilder cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PessoaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public Pessoa build() {
        return new Pessoa(nome, dataNascimento, cpf, email);
    }
}
