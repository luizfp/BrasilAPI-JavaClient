package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.Address;
import br.com.brasilapi.javaclient.cep.CepApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.Duration;
import java.util.Objects;

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
    public Address findByCep(@NotNull final String cep) {
        return cepApi.findByCep(cep);
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
        public BrasilApi build() {
            final BrasilApiConfig config = BrasilApiConfig.of(networkTimeout);
            return new BrasilApi(config);
        }
    }
}
