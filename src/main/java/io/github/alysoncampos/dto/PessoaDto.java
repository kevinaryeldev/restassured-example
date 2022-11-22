package io.github.alysoncampos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PessoaDto {

    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String idPessoa;

}
