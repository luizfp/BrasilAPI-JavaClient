package br.com.brasilapi.javaclient.network.errorhandler;

import br.com.brasilapi.javaclient.json.JsonParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
            return new ErrorResponseParser<>(
                    jsonParser,
                    errorResponse,
                    getExpectedErrorType())
                    .parse(this::buildCustomException);
        } else {
            return new BrasilApiException("Unknown exception");
        }
    }

    @NotNull
    public abstract Class<T> getExpectedErrorType();

    @NotNull
    public abstract BrasilApiException buildCustomException(@NotNull final T error);
}
