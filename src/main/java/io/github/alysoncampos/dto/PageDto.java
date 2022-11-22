package io.github.alysoncampos.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class PageDto {

    private String totalElements;
    private String totalPages;
    private String page;
    private String size;
    private List<PessoaDto> content;

}
