package br.com.brasilapi.javaclient;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class Constants {
    public static final String BASE_API_URL = "https://brasilapi.com.br/api/";
    public static final long DEFAULT_NETWORK_TIMEOUT_SECONDS = 30;

    private Constants() {
        throw new IllegalStateException(Constants.class.getSimpleName() + " cannot be instantiated!");
    }
}
