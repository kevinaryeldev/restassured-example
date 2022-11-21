package io.github.alysoncampos.data.factory;

import io.github.alysoncampos.model.Pessoa;
import io.github.alysoncampos.model.PessoaBuilder;
import io.github.alysoncampos.utils.Utils;
import org.apache.commons.lang3.StringUtils;


import java.text.SimpleDateFormat;

public class PessoaDataFactory {

    private static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    private PessoaDataFactory() {}

    public static String nomeInexistente() {
        return Utils.faker.name().firstName();
    }

    public static String cpfInexistente() {
        return Utils.faker.cpf().valid(false);
    }

    public static Pessoa pesssoaValida() {
        return novaPessoa();
    }

    public static Pessoa pessoaSemNome() {
        Pessoa pessoaSemNome = pesssoaValida();
        pessoaSemNome.setNome(StringUtils.EMPTY);

        return pessoaSemNome;
    }

    public static Pessoa pessoaSemDataNascimento() {
        Pessoa pessoaSemDataNascimento = pesssoaValida();
        pessoaSemDataNascimento.setDataNascimento(StringUtils.EMPTY);

        return pessoaSemDataNascimento;
    }

    public static Pessoa pessoaSemCpf() {
        Pessoa pessoaSemCpf = pesssoaValida();
        pessoaSemCpf.setCpf(StringUtils.EMPTY);

        return pessoaSemCpf;
    }

    private static Pessoa novaPessoa() {
        Pessoa pessoa = new PessoaBuilder().
                nome(Utils.faker.name().fullName()).
                dataNascimento(data.format(Utils.faker.date().birthday())).
                cpf(Utils.faker.cpf().valid(false)).
                email(Utils.faker.internet().emailAddress()).
                build();

        return pessoa;
    }
}
