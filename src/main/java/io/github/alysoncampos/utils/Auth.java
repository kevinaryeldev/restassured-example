package io.github.alysoncampos.utils;

import com.google.gson.Gson;
import io.github.alysoncampos.data.changeless.LoginData;
import io.github.alysoncampos.model.Login;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Auth {

    public String autenticacao(){
        Login login = new Login();

        login.setLogin(Manipulation.getProp().getProperty("prop.login"));
        login.setSenha(Manipulation.getProp().getProperty("prop.senha"));

        return
                given()
                    .contentType(ContentType.JSON)
                    .body(new Gson().toJson(login))
                .when()
                    .post(LoginData.SERVICE)
                .then()
                    .extract().asString()
                ;
    }

}
