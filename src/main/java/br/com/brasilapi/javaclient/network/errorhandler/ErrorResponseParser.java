package br.com.brasilapi.javaclient.network.errorhandler;

import br.com.brasilapi.javaclient.json.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class ErrorResponseParser<T> {
    @NotNull
    private final JsonParser jsonParser;
    @NotNull
    private final ErrorResponse errorResponse;
    @NotNull
    private final Class<T> expectedErrorType;

    public ErrorResponseParser(@NotNull final JsonParser jsonParser,
                               @NotNull final ErrorResponse errorResponse,
                               @NotNull final Class<T> expectedErrorType) {
        this.jsonParser = jsonParser;
        this.errorResponse = errorResponse;
        this.expectedErrorType = expectedErrorType;
    }

    @NotNull
    public BrasilApiException parse(@NotNull final CustomExceptionBuilder<T> customExceptionBuilder) {
        if (errorResponse.hasErrorBody()) {
            return tryParseErrorBody(customExceptionBuilder);
        } else {
            return new BrasilApiException("No error body!");
        }
    }

    @NotNull
    private BrasilApiException tryParseErrorBody(@NotNull final CustomExceptionBuilder<T> customExceptionBuilder) {
        return parseErrorBodyToJson()
                .map(customExceptionBuilder::buildException)
                .orElseGet(() -> new BrasilApiException("Error to parse body!"));
    }

    @NotNull
    private Optional<T> parseErrorBodyToJson() {
        try {
            final String errorBody = errorResponse.getErrorBody();
            final T value = jsonParser.fromJson(errorBody, expectedErrorType);
            return Optional.of(value);
        } catch (final Throwable ignored) {
            return Optional.empty();
        }
    }
}
