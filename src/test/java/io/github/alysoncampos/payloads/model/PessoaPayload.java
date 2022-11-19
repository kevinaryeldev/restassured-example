package io.github.alysoncampos.payloads.model;

import com.google.gson.Gson;
import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;
import io.github.alysoncampos.utils.Utils;

import java.text.SimpleDateFormat;

public class PessoaPayload {

    static SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");

    public static String pessoaCompletaJson() {
        PessoaModel pessoa = new PessoaModel(
                Utils.faker.name().fullName(),
                data.format(Utils.faker.date().birthday()),
                Utils.faker.cpf().valid(false),
                Utils.faker.internet().emailAddress()
        );
        return new Gson().toJson(pessoa);
    }
}
