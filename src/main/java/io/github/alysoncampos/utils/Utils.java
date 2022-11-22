package io.github.alysoncampos.utils;

import com.google.gson.Gson;
import io.github.alysoncampos.model.Pessoa;
import net.datafaker.Faker;
import org.junit.Assert;

import java.util.Locale;

public class Utils {

    public static Faker faker = new Faker(new Locale("pt-BR"));

    public enum Env {
        DEV, HML, PRD
    }

    public static String getBaseUrl() {
        String baseUrl = null;
        Env env = envStringToEnum();

        switch (env) {
            case PRD -> {
                baseUrl = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";
            }
            default -> {
                Assert.fail("Ambiente não configurado");
            }
        }
        return baseUrl;
    }

    public static Env envStringToEnum() {
        try {
            return Env.valueOf(getEnv());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ambiente não existente: " + getEnv());
        }
    }

    public static String getEnv() {
        return Manipulation.getProp().getProperty("prop.env");
    }

    public static String convertPessoaToJson(Pessoa pessoa) {
        return new Gson().toJson(pessoa);
    }

    public static Pessoa convertJsonToPessoa(String toJson) {
        return new Gson().fromJson(toJson, Pessoa.class);
    }

}
