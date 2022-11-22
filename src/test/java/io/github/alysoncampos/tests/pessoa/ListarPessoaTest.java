package io.github.alysoncampos.tests.pessoa;

import io.github.alysoncampos.client.PessoaClient;
import io.github.alysoncampos.dto.PageDto;
import io.github.alysoncampos.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ListarPessoaTest extends BaseTest {

    PessoaClient pessoaClient = new PessoaClient();

    @Test
    @Tag("todos")
    @Description("Deve listar pessoas com paginação")
    public void deveListarPessoasComPaginacao() {
        PageDto pageDto = pessoaClient.listar()
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().as(PageDto.class)
                ;

        assertAll("pageDto",
                () -> assertEquals("0", pageDto.getPage()),
                () -> assertEquals("20", pageDto.getSize())
        );
    }
}
