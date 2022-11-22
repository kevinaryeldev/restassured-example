package io.github.alysoncampos.tests.pessoa;

import io.github.alysoncampos.client.PessoaClient;
import io.github.alysoncampos.data.factory.PessoaDataFactory;
import io.github.alysoncampos.model.Pessoa;
import io.github.alysoncampos.tests.base.BaseTest;
import io.github.alysoncampos.utils.Utils;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CadastrarPessoaTest extends BaseTest {

    PessoaClient pessoaClient = new PessoaClient();

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa com sucesso")
    public void deveCadastrarPessoaComSucesso() {
        Pessoa pessoa = PessoaDataFactory.pesssoaValida();

        Integer idPessoa = pessoaClient.cadastrar(Utils.convertPessoaToJson(pessoa))
                .then()
                        .log().all()
                        .statusCode(HttpStatus.SC_OK)
                        .body("nome", equalTo(pessoa.getNome()))
                        .body("cpf", equalTo(pessoa.getCpf()))
                        .extract().path("idPessoa")
                ;

        pessoaClient.excluir(idPessoa)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                ;
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa nome em branco")
    public void deveCadastrarPessoaNomeEmBranco() {
        Pessoa pessoaSemNome = PessoaDataFactory.pessoaSemNome();

        pessoaClient.cadastrar(Utils.convertPessoaToJson(pessoaSemNome))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("nome: must not be blank"))
        ;
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa data nascimento em branco")
    public void deveCadastrarPessoaDataNascimentoEmBranco() {
        Pessoa pessoaSemDataNascimento = PessoaDataFactory.pessoaSemDataNascimento();

        pessoaClient.cadastrar(Utils.convertPessoaToJson(pessoaSemDataNascimento))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(containsString("dataNascimento: must not be null"))
        ;
    }

    @Test
    @Tag("todos")
    @Description("Deve cadastrar pessoa cpf em branco")
    public void deveCadastrarPessoaCpfEmBranco() {
        Pessoa pessoaSemCpf = PessoaDataFactory.pessoaSemCpf();

        pessoaClient.cadastrar(Utils.convertPessoaToJson(pessoaSemCpf))
                .then()
                    .log().all()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

}
