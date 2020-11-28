package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.log.HttpLogLevel;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;

/**
 * Created on 2020-11-23
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class BrasilApiConfig {
    @NotNull
    private final Duration networkTimeout;
    @NotNull
    private final HttpLogLevel httpLogLevel;
    private final boolean httpLogsEnabled;

    private BrasilApiConfig(@NotNull final Duration networkTimeout,
                            @NotNull final HttpLogLevel httpLogLevel,
                            final boolean httpLogsEnabled) {
        this.networkTimeout = networkTimeout;
        this.httpLogLevel = httpLogLevel;
        this.httpLogsEnabled = httpLogsEnabled;
    }

    @NotNull
    public Duration getNetworkTimeout() {
        return networkTimeout;
    }

    @NotNull
    public HttpLogLevel getHttpLogLevel() {
        return httpLogLevel;
    }

    public boolean isHttpLogsEnabled() {
        return httpLogsEnabled;
    }

    @NotNull
    public static BrasilApiConfig of(@NotNull final Duration networkTimeout,
                                     @NotNull final HttpLogLevel httpLogLevel,
                                     final boolean logsEnabled) {
        return new BrasilApiConfig(networkTimeout, httpLogLevel, logsEnabled);
    }
}
