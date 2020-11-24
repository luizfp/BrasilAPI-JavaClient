package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.BrasilApiConfig;
import br.com.brasilapi.javaclient.Injection;
import br.com.brasilapi.javaclient.network.ErrorListener;
import br.com.brasilapi.javaclient.network.SuccessListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepRequest {
    @Nullable
    private SuccessListener successListener;
    @Nullable
    private ErrorListener errorListener;
    @NotNull
    private final CepApi cepApi;
    @NotNull
    private final String cep;

    public CepRequest(@NotNull final CepApi cepApi,
                      @NotNull final String cep) {
        this.cepApi = cepApi;
        this.cep = cep;
    }

    @NotNull
    public CepRequest doOnSuccess(@NotNull final SuccessListener successListener) {
        this.successListener = successListener;
        return this;
    }

    @NotNull
    public CepRequest doOnError(@NotNull final ErrorListener errorListener) {
        this.errorListener = errorListener;
        return this;
    }

    @NotNull
    public Optional<Address> execute() {
        try {
            final Address address = cepApi.findByCep(cep);
            fireSuccess(address);
            return Optional.of(address);
        } catch (final Throwable throwable) {
            fireError(throwable);
        }

        return Optional.empty();
    }

    private void fireSuccess(@NotNull final Address address) {
        if (successListener != null) {
            successListener.onSuccess(address);
        }
    }

    private void fireError(@Nullable final Throwable throwable) {
        if (errorListener != null) {
            errorListener.onError(null);
        }
    }
}
