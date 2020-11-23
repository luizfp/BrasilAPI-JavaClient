package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.util.Verifier;
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
    private final Duration networkTimeout;

    private BrasilApiConfig(@NotNull final Duration networkTimeout) {
        this.networkTimeout = networkTimeout;
    }

    @NotNull
    public Duration getNetworkTimeout() {
        return networkTimeout;
    }

    public static final class Builder {
        @Nullable
        private Duration networkTimeout;

        public Builder() {
        }

        public Builder withNetworkTimeout(@NotNull final Duration networkTimeout) {
            this.networkTimeout = networkTimeout;
            return this;
        }

        @NotNull
        public BrasilApiConfig build() {
            return new BrasilApiConfig(
                    Verifier.checkNotNull(networkTimeout, "networkTimeout cannot be null!")
            );
        }
    }
}
