package br.com.brasilapi.javaclient.cep.error;

import br.com.brasilapi.javaclient.json.JsonParser;
import br.com.brasilapi.javaclient.network.errorhandler.BrasilApiException;
import br.com.brasilapi.javaclient.network.errorhandler.ResponseErrorHandler;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class CepErrorHandler extends ResponseErrorHandler<CepError> {

    public CepErrorHandler(@NotNull final JsonParser jsonParser) {
        super(jsonParser);
    }

    @NotNull
    @Override
    public Class<CepError> getExpectedErrorType() {
        return CepError.class;
    }

    @NotNull
    @Override
    public BrasilApiException buildCustomException(@NotNull final CepError error) {
        return new CepApiException(error);
    }
}
