package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.cep.error.CepError;
import br.com.brasilapi.javaclient.cep.response.CepErrorResponse;
import br.com.brasilapi.javaclient.cep.response.CepResponse;
import br.com.brasilapi.javaclient.cep.response.CepSuccessResponse;
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
    @Nullable
    private Address address;

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
    public Optional<Address> thenReturning() {
        internalExecute();
        return Optional.ofNullable(address);
    }

    public void execute() {
        internalExecute();
    }

    private void internalExecute() {
        final CepResponse response = cepApi.findByCep(cep);
        if (response.wasSuccessful()) {
            address = ((CepSuccessResponse) response).getAddress();
            fireSuccess(address);
        } else {
            fireError(((CepErrorResponse) response).getCepError());
        }
    }

    private void fireSuccess(@NotNull final Address address) {
        if (successListener != null) {
            successListener.onSuccess(address);
        }
    }

    private void fireError(@NotNull final CepError error) {
        if (errorListener != null) {
            errorListener.onError(error);
        }
    }
}
