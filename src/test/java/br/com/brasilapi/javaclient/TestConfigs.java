package br.com.brasilapi.javaclient;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-28
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class TestConfigs {
    @NotNull
    public static final BrasilApiConfig DEFAULT_BRASIL_API_CONFIG;

    static {
        DEFAULT_BRASIL_API_CONFIG = BrasilApiConfig.of(
                Constants.DEFAULT_NETWORK_TIMEOUT,
                Constants.DEFAULT_HTTP_LOG_LEVEL,
                Constants.DEFAULT_HTTP_LOGS_ENABLED);
    }

    private TestConfigs() {
        throw new IllegalStateException(TestConfigs.class.getSimpleName() + " cannot be instantiated!");
    }
}
