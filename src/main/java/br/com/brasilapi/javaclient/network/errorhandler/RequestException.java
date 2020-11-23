package br.com.brasilapi.javaclient.network.errorhandler;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class RequestException extends BrasilApiException {
    @NotNull
    private final ErrorResponse errorResponse;

    public RequestException(@NotNull final ErrorResponse errorResponse) {
        super("");
        this.errorResponse = errorResponse;
    }

    @NotNull
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
