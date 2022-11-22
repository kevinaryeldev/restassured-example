package io.github.alysoncampos.data.changeless;

public final class PessoaData {

    private PessoaData() {}

    public static final String SERVICE = "/pessoa";
    public static final String GET_BY_NAME = String.format("%s/byname", SERVICE);
    public static final String GET_BY_CPF = String.format("%s/{cpf}/cpf", SERVICE);
    public static final String BY_ID = String.format("%s/{idPessoa}", SERVICE);
    public static final String ID_PESSOA = "idPessoa";
    public static final String NOME = "nome";

}
