package io.github.alysoncampos.tests.pessoa.requests;

import io.github.alysoncampos.utils.Auth;
import io.github.alysoncampos.utils.Values;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PessoaRequest {

    private final String PATH_PESSOA = "/pessoa";
    private String token = new Auth().autenticacao();

    public Response listar() {
        return given()
                    .header(Values.AUTHORIZATION, token)
                .when()
                    .get(PATH_PESSOA);
    }

    public Response listarPorNome(String nome) {
        return given()
                    .log().all()
                    .header(Values.AUTHORIZATION, token)
                    .queryParam("nome", nome)
                .when()
                    .get(PATH_PESSOA + "/byname")
                ;
    }

    public Response cadastrar(String pessoa) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(pessoa)
                .header(Values.AUTHORIZATION, token)
                .when()
                .post(PATH_PESSOA)
                ;
    }

    public Response excluir(Integer idPessoa) {
        return given()
                .pathParam("idPessoa", idPessoa)
                .header(Values.AUTHORIZATION, token)
                .when()
                .delete(PATH_PESSOA + "/{idPessoa}")
                ;

    }

}
