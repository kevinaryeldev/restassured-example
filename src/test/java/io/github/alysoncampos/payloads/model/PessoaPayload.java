package io.github.alysoncampos.payloads.model;

import com.google.gson.Gson;
import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;
import io.github.alysoncampos.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

public class PessoaPayload {

    static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public static String pessoaValidaJson() {
        PessoaModel pessoaModel = novaPessoa();
        return new Gson().toJson(pessoaModel);
    }

    public static String pessoaValidaJson(String nome, String dataNascimento, String cpf, String email) {
        PessoaModel pessoaModel = new PessoaModel(nome, dataNascimento, cpf, email);
        return new Gson().toJson(pessoaModel);
    }

    public static String pessoaSemDadosObrigatoriosJson() {
        PessoaModel pessoaModel = novaPessoa();
        pessoaModel.setNome(StringUtils.EMPTY);
        pessoaModel.setDataNascimento(StringUtils.EMPTY);

        return new Gson().toJson(pessoaModel);
    }

    public static String pessoaSemCpfJson() {
        PessoaModel pessoaModel = novaPessoa();
        pessoaModel.setCpf(StringUtils.EMPTY);

        return new Gson().toJson(pessoaModel);
    }

    private static PessoaModel novaPessoa() {
        PessoaModel pessoaModel = new PessoaModel(
                Utils.faker.name().fullName(),
                data.format(Utils.faker.date().birthday()),
                Utils.faker.cpf().valid(false),
                Utils.faker.internet().emailAddress()
        );
        return pessoaModel;
    }

}
