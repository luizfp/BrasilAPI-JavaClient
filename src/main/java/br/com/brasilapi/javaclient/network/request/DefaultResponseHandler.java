package br.com.brasilapi.javaclient.network.request;

import br.com.brasilapi.javaclient.cep.error.CepError;
import br.com.brasilapi.javaclient.network.errorhandler.ErrorResponse;
import br.com.brasilapi.javaclient.network.errorhandler.RequestException;
import br.com.brasilapi.javaclient.network.errorhandler.ResponseErrorHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

import java.util.Objects;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class DefaultResponseHandler implements ResponseHandler {

    @NotNull
    @Override
    public <T> T handleResponse(@Nullable final Response<T> response) {
        if (isResponseSuccess(response)) {
            return Objects.requireNonNull(response.body());
        } else {
            throw new RequestException(ErrorResponse.of(response));
        }
    }

    private <T> boolean isResponseSuccess(@Nullable final Response<T> response) {
        return response != null && response.isSuccessful() && response.body() != null;
    }
}
