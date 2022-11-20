package io.github.alysoncampos.example.data.factory;

import io.github.alysoncampos.example.model.Pessoa;
import io.github.alysoncampos.example.model.PessoaBuilder;
import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;
import io.github.alysoncampos.utils.Utils;
import org.apache.commons.lang3.StringUtils;


import java.text.SimpleDateFormat;

public class PessoaDataFactory {

    static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public String nomeNaoExistente() {
        return Utils.faker.name().firstName();
    }

    public String cpfNaoExistente() {
        return Utils.faker.cpf().valid(false);
    }

    public Pessoa pesssoaValida() {
        return novaPessoa();
    }

    public Pessoa pessoaSemCpf() {
        Pessoa pessoaSemCpf = pesssoaValida();
        pessoaSemCpf.setCpf(StringUtils.EMPTY);

        return pessoaSemCpf;
    }

    private Pessoa novaPessoa() {
        Pessoa pessoa =
                new PessoaBuilder()
                    .nome(Utils.faker.name().fullName())
                    .dataNascimento(data.format(Utils.faker.date().birthday()))
                    .cpf(Utils.faker.cpf().valid(false))
                    .email(Utils.faker.internet().emailAddress()).build();
        return pessoa;
    }
}
