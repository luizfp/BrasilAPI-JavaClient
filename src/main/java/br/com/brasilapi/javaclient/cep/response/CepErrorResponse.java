package br.com.brasilapi.javaclient.cep.response;

import br.com.brasilapi.javaclient.cep.error.CepError;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepErrorResponse implements CepResponse {
    @NotNull
    private final CepError cepError;

    public CepErrorResponse(@NotNull final CepError cepError) {
        this.cepError = cepError;
    }

    @Override
    public boolean wasSuccessful() {
        return false;
    }

    @NotNull
    public CepError getCepError() {
        return cepError;
    }
}
