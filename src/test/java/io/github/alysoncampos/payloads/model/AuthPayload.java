package io.github.alysoncampos.payloads.model;

import com.google.gson.Gson;
import io.github.alysoncampos.payloads.model.auth.AuthModel;

public class AuthPayload {

    public static String authToJson(String login, String senha) {
        AuthModel auth = new AuthModel(login, senha);
        return new Gson().toJson(auth);
    }
    
}
