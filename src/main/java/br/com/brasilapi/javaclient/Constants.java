package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.log.HttpLogLevel;

import java.time.Duration;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class Constants {
    public static final String BASE_API_URL = "https://brasilapi.com.br/api/";
    public static final Duration DEFAULT_NETWORK_TIMEOUT = Duration.ofSeconds(30);
    public static final HttpLogLevel DEFAULT_HTTP_LOG_LEVEL = HttpLogLevel.BODY;
    public static final boolean DEFAULT_HTTP_LOGS_ENABLED = false;

    private Constants() {
        throw new IllegalStateException(Constants.class.getSimpleName() + " cannot be instantiated!");
    }
}
