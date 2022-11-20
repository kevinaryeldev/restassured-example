package io.github.alysoncampos.payloads.model.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthModel {

    private String login;
    private String senha;

    public AuthModel(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

}
