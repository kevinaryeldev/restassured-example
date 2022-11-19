package io.github.alysoncampos.tests.pessoa.tests;

import io.github.alysoncampos.payloads.model.PessoaPayload;
import io.github.alysoncampos.tests.base.tests.BaseTest;
import io.github.alysoncampos.tests.pessoa.requests.PessoaRequest;
import io.github.alysoncampos.utils.Utils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class CadastrarPessoaTest extends BaseTest {

    PessoaRequest pessoaRequest = new PessoaRequest();

    @Test
    public void deveCadastrarPessoaComSucesso() {
        String pessoa = PessoaPayload.pessoaCompletaJson();

        Integer idPessoa = pessoaRequest.cadastrar(pessoa)
                .then()
                        .statusCode(HttpStatus.SC_OK)
                        .body("nome", equalTo(Utils.convertJsonToObj(pessoa).getNome()))
                        .body("cpf", equalTo(Utils.convertJsonToObj(pessoa).getCpf()))
                        .extract().path("idPessoa")
                ;

        pessoaRequest.excluir(idPessoa)
                .then()
                .statusCode(HttpStatus.SC_OK)
        ;
    }
}
