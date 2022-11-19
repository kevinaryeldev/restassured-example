package io.github.alysoncampos.utils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Auth {

    String baseUrl = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api/auth";

    public String autenticacaoAdmin() {

        return given()
                .contentType(ContentType.JSON)
                .body("{\"login\" : \"admin\", \"senha\" : \"123\"}")
        .when()
                .post(baseUrl)
        .then()
                .extract().asString()
        ;
    }
}
