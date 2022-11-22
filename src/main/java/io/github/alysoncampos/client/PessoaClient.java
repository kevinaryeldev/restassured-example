package io.github.alysoncampos.client;

import io.github.alysoncampos.data.changeless.PessoaData;
import io.github.alysoncampos.utils.Auth;
import io.github.alysoncampos.data.changeless.Values;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PessoaClient {

    private String token = new Auth().autenticacao();

    public Response listar() {
        return
                given()
                    .header(Values.AUTHORIZATION, token)
                .when()
                    .get(PessoaData.SERVICE)
                ;
    }

    public Response listarPorNome(String nome) {
        return
                given()
                    .log().all()
                    .header(Values.AUTHORIZATION, token)
                    .queryParam(PessoaData.NOME, nome)
                .when()
                    .get(PessoaData.GET_BY_NAME)
                ;
    }

    public Response cadastrar(String pessoa) {
        return
                given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(pessoa)
                    .header(Values.AUTHORIZATION, token)
                .when()
                    .post(PessoaData.SERVICE)
                ;
    }

    public Response excluir(Integer idPessoa) {
        return
                given()
                    .pathParam(PessoaData.ID_PESSOA, idPessoa)
                    .header(Values.AUTHORIZATION, token)
                .when()
                    .delete(PessoaData.BY_ID)
                ;
    }

}
