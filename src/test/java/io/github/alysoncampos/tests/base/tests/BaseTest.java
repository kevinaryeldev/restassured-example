package io.github.alysoncampos.tests.base.tests;

import io.github.alysoncampos.utils.Utils;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class BaseTest {

    @BeforeAll
    public static void setUp(){
        log.info("Iniciando os testes de API.");
        RestAssured.baseURI = Utils.getBaseUrl();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}
