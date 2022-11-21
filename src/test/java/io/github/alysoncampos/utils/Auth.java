package io.github.alysoncampos.utils;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Auth {

    private final String BASE_URL = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api/auth";

    public String autenticacao() {

        return given()
                .contentType(ContentType.JSON)
                .body("{\"login\" : \"admin\", \"senha\" : \"123\"}")
        .when()
                .post(BASE_URL)
        .then()
                .extract().asString()
        ;
    }
}
