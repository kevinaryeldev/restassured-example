package io.github.alysoncampos.client;

import io.github.alysoncampos.data.changeless.PessoaData;
import io.github.alysoncampos.specs.PessoaSpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PessoaClient {

    public Response listar() {
        return
                given()
                    .spec(PessoaSpecs.requestSpec())
                .when()
                    .get(PessoaData.SERVICE)
                ;
    }

    public Response listarPorNome(String nome) {
        return
                given()
                    .spec(PessoaSpecs.requestSpec())
                    .queryParam(PessoaData.NOME, nome)
                .when()
                    .get(PessoaData.GET_BY_NAME)
                ;
    }

    public Response cadastrar(String pessoa) {
        return
                given()
                    .spec(PessoaSpecs.requestSpec())
                    .body(pessoa)
                .when()
                    .post(PessoaData.SERVICE)
                ;
    }

    public Response excluir(Integer idPessoa) {
        return
                given()
                    .spec(PessoaSpecs.requestSpec())
                    .pathParam(PessoaData.ID_PESSOA, idPessoa)
                .when()
                    .delete(PessoaData.BY_ID)
                ;
    }

}
