package io.github.alysoncampos.tests.pessoa.tests;

import com.google.gson.Gson;
import io.github.alysoncampos.example.data.factory.PessoaDataFactory;
import io.github.alysoncampos.payloads.model.PessoaPayload;
import io.github.alysoncampos.payloads.model.pessoa.PessoaModel;
import io.github.alysoncampos.tests.base.tests.BaseTest;
import io.github.alysoncampos.tests.pessoa.requests.PessoaRequest;
import io.github.alysoncampos.utils.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CadastrarPessoaTest extends BaseTest {

    PessoaRequest pessoaRequest = new PessoaRequest();
    PessoaDataFactory pessoaDataFactory = new PessoaDataFactory();

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa com sucesso")
    public void deveCadastrarPessoaComSucesso() {
        String pessoa = PessoaPayload.pessoaValidaJson();

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

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa cpf em branco")
    public void deveCadastrarPessoaCpfEmBranco() {
        pessoaRequest.cadastrar(PessoaPayload.pessoaSemCpfJson())
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa sem dados obrigatórios")
    public void deveCadastrarPessoaSemDadosObrigatorios() {
        pessoaRequest.cadastrar(PessoaPayload.pessoaSemDadosObrigatoriosJson())
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("nome: must not be blank"))
                    .body(containsString("dataNascimento: must not be null"))
                ;
    }

}
