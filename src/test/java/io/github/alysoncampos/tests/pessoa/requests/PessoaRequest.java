package io.github.alysoncampos.tests.pessoa.requests;

import io.github.alysoncampos.utils.Auth;
import io.github.alysoncampos.utils.Utils;
import io.github.alysoncampos.utils.Values;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PessoaRequest {


    private String tokenAdmin = new Auth().autenticacaoAdmin();

    public Response listar() {
        return given()
                        .header(Values.AUTH, tokenAdmin)
                .when()
                        .get(Values.PATH_PESSOA);
    }

    public Response cadastrar(String pessoa) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(pessoa)
                .header(Values.AUTH, tokenAdmin)
                .when()
                .post(Values.PATH_PESSOA)
                ;
    }

    public Response excluir(Integer idPessoa) {
        return given()
                .pathParam("idPessoa", idPessoa)
                .header(Values.AUTH, tokenAdmin)
                .when()
                .delete(Values.PATH_PESSOA + "/{idPessoa}")
                ;

    }

}
