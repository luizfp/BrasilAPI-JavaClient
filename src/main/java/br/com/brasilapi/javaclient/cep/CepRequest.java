package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.BrasilApiConfig;
import br.com.brasilapi.javaclient.Injection;
import br.com.brasilapi.javaclient.network.ErrorListener;
import br.com.brasilapi.javaclient.network.SuccessListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    private final String cep;
    @NotNull
    private final CepApi cepApi;

    public CepRequest(@NotNull final String cep) {
        this.cep = cep;
        this.cepApi = Injection.provideCepApi(BrasilApiConfig.of(null));
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

    public void execute() {
        try {
            final Address address = cepApi.findByCep(cep);
            fireSuccess(address);
        } catch (final Throwable throwable) {
            fireError(throwable);
        }
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
