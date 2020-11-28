package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.CepApi;
import br.com.brasilapi.javaclient.cep.CepRequest;
import br.com.brasilapi.javaclient.log.HttpLogLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class BrasilApi {
    @NotNull
    private final CepApi cepApi;

    private BrasilApi(@NotNull final BrasilApiConfig config) {
        this.cepApi = Injection.provideCepApi(config);
    }

    @NotNull
    public CepRequest findByCep(@NotNull final String cep) {
        return new CepRequest(cepApi, cep);
    }

    public static final class Builder {
        @Nullable
        private Duration networkTimeout;
        @Nullable
        private HttpLogLevel httpLogLevel;
        private boolean httpLogsEnabled;

        public Builder() {
        }

        @NotNull
        public Builder withNetworkTimeout(@NotNull final Duration networkTimeout) {
            this.networkTimeout = networkTimeout;
            return this;
        }

        @NotNull
        public Builder withHttpLogLevel(@NotNull final HttpLogLevel httpLogLevel) {
            this.httpLogLevel = httpLogLevel;
            return this;
        }

        @NotNull
        public Builder withHttpLogsEnabled(final boolean httpLogsEnabled) {
            this.httpLogsEnabled = httpLogsEnabled;
            return this;
        }

        @NotNull
        public BrasilApi build() {
            final BrasilApiConfig config = BrasilApiConfig.of(
                    networkTimeout != null ? networkTimeout : Constants.DEFAULT_NETWORK_TIMEOUT,
                    httpLogLevel != null ? httpLogLevel : Constants.DEFAULT_HTTP_LOG_LEVEL,
                    httpLogsEnabled);
            return new BrasilApi(config);
        }
    }
}
