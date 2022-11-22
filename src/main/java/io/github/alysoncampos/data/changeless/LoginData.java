package io.github.alysoncampos.data.changeless;

import io.github.alysoncampos.utils.Utils;

public final class LoginData {

    public static final String BASE_URL = Utils.getBaseUrl();
    public static final String SERVICE = String.format("%s/auth", BASE_URL);

}
