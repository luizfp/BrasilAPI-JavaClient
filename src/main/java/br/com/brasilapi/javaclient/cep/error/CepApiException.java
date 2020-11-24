package br.com.brasilapi.javaclient.cep.error;

import br.com.brasilapi.javaclient.network.errorhandler.BrasilApiException;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepApiException extends BrasilApiException {
    @NotNull
    private final CepError error;

    public CepApiException(@NotNull final CepError error) {
        this.error = error;
    }

    @NotNull
    public CepError getError() {
        return error;
    }
}
