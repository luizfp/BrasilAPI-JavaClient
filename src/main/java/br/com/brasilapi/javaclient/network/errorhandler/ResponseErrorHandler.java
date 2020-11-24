package br.com.brasilapi.javaclient.network.errorhandler;

import br.com.brasilapi.javaclient.cep.error.CepError;
import br.com.brasilapi.javaclient.json.JsonParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public abstract class ResponseErrorHandler<T> {
    @NotNull
    private final JsonParser jsonParser;

    public ResponseErrorHandler(@NotNull final JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    @NotNull
    public final BrasilApiException translateException(@Nullable final Throwable throwable) {
        if (throwable instanceof RequestException) {
            final RequestException requestException = (RequestException) throwable;
            final ErrorResponse errorResponse = requestException.getErrorResponse();
            if (errorResponse.hasErrorBody()) {
                return tryParseErrorResponse(errorResponse)
                        .map(this::buildCustomException)
                        .orElseGet(() -> new BrasilApiException("Error to parse body!"));
            } else {
                return new BrasilApiException("No error body!");
            }
        } else {
            return new BrasilApiException("Unknown exception");
        }
    }

    @NotNull
    private Optional<T> tryParseErrorResponse(@NotNull final ErrorResponse errorResponse) {
        try {
            final T value = jsonParser.fromJson(errorResponse.getErrorBody(), getExpectedErrorType());
            return Optional.of(value);
        } catch (final Throwable ignored) {
            return Optional.empty();
        }
    }

    @NotNull
    public abstract Class<T> getExpectedErrorType();

    @NotNull
    public abstract BrasilApiException buildCustomException(@NotNull final T error);
}
