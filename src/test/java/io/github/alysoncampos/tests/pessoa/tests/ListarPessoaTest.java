package io.github.alysoncampos.tests.pessoa.tests;

import io.github.alysoncampos.tests.base.tests.BaseTest;
import io.github.alysoncampos.tests.pessoa.requests.PessoaRequest;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class ListarPessoaTest extends BaseTest {

    PessoaRequest pessoaRequest = new PessoaRequest();

    @Test
    public void deveListarTodasPessoasComSucesso() {
        pessoaRequest.listar()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
