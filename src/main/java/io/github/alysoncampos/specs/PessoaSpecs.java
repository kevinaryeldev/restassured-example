package io.github.alysoncampos.specs;

import io.github.alysoncampos.data.changeless.Values;
import io.github.alysoncampos.utils.Auth;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PessoaSpecs {

    private static String token = new Auth().autenticacao();

    private PessoaSpecs() {}

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder().
                addHeader(Values.AUTHORIZATION, token).
                setContentType(ContentType.JSON).
                build();
    }

}
