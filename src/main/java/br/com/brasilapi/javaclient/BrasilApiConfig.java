package br.com.brasilapi.javaclient;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;

/**
 * Created on 2020-11-23
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class BrasilApiConfig {
    @NotNull
    private static final BrasilApiConfig DEFAULT_CONFIG;
    @NotNull
    private final Duration networkTimeout;

    static {
        DEFAULT_CONFIG = new BrasilApiConfig(Duration.ofSeconds(Constants.DEFAULT_NETWORK_TIMEOUT_SECONDS));
    }

    private BrasilApiConfig(@NotNull final Duration networkTimeout) {
        this.networkTimeout = networkTimeout;
    }

    @NotNull
    public Duration getNetworkTimeout() {
        return networkTimeout;
    }

    @NotNull
    public static BrasilApiConfig of(@Nullable final Duration networkTimeout) {
        if (networkTimeout == null) {
            return BrasilApiConfig.DEFAULT_CONFIG;
        } else {
            return new BrasilApiConfig(networkTimeout);
        }
    }
}
