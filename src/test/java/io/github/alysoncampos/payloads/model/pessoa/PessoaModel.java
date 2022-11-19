package io.github.alysoncampos.payloads.model.pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel {

    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;

    public PessoaModel(String nome, String dataNascimento, String cpf, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.email = email;
    }
}
