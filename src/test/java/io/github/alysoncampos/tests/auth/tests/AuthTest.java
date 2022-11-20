package io.github.alysoncampos.tests.auth.tests;

import io.github.alysoncampos.tests.auth.requests.AuthRequest;
import io.github.alysoncampos.tests.base.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.*;

@Feature("Login")
public class AuthTest extends BaseTest {

    AuthRequest authRequest = new AuthRequest();

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com sucesso")
    public void deveRealizarOLoginComSucesso() {
        authRequest.logar("admin", "123")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(startsWith("Bearer"))
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com login inválido")
    public void deveRealizarOLoginComLoginInvalido() {
        authRequest.logar("123456789", "123")
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com login em branco")
    public void deveRealizarOLoginComLoginEmBranco() {
        authRequest.logar("", "123")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("login: must not be blank"))
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com senha inválida")
    public void deveRealizarOLoginComSenhaInvalida() {
        authRequest.logar("admin", "senhaerrada123")
                .then()
                .statusCode(HttpStatus.SC_FORBIDDEN)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com senha em branco")
    public void deveRealizarOLoginComSenhaEmBranco() {
        authRequest.logar("admin", "")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("senha: must not be blank"))
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve realizar o login com login e senha em branco")
    public void deveRealizarOLoginComLoginESenhaEmBranco() {
        authRequest.logar("", "")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(containsString("senha: must not be blank"))
                .body(containsString("login: must not be blank"))
                ;
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser realizado um GET no login")
    public void naoDeveSerRealizadoUmGetNoLogin() {
        authRequest.getLogin("admin", "123")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser realizado um PUT no login")
    public void naoDeveSerRealizadoUmPutNoLogin() {
        authRequest.putLogin("admin", "123")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Não deve ser realizado um DELETE no login")
    public void naoDeveSerRealizadoUmDeleteNoLogin() {
        authRequest.deleteLogin("admin", "123")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)
                ;
    }

}
