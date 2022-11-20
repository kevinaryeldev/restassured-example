package io.github.alysoncampos.tests.auth.requests;

import io.github.alysoncampos.payloads.model.AuthPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AuthRequest {

    private final String PATH_AUTH = "/auth";

    public Response logar(String login, String senha) {
        return given()
                    .contentType(ContentType.JSON)
                    .body(AuthPayload.authToJson(login, senha))
                .when()
                    .post(PATH_AUTH)
                ;
    }

    public Response getLogin(String login, String senha) {
        return given()
                    .contentType(ContentType.JSON)
                    .body(AuthPayload.authToJson(login, senha))
                .when()
                    .get(PATH_AUTH)
                ;
    }

    public Response putLogin(String login, String senha) {
        return given()
                    .contentType(ContentType.JSON)
                    .body(AuthPayload.authToJson(login, senha))
                .when()
                    .put(PATH_AUTH)
                ;
    }

    public Response deleteLogin(String login, String senha) {
        return given()
                    .contentType(ContentType.JSON)
                    .body(AuthPayload.authToJson(login, senha))
                .when()
                    .delete(PATH_AUTH)
                ;
    }

}
