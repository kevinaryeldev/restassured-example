package io.github.alysoncampos.utils;


import com.google.gson.Gson;
import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;
import net.datafaker.Faker;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public static String getBaseUrl() {
        return "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";
    }

    public static PessoaModel convertJsonToObj(String toJson) {
        return new Gson().fromJson(toJson, PessoaModel.class);
    }

}
