package br.com.brasilapi.javaclient.network.errorhandler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class ErrorResponse {
    @Nullable
    private final Response<?> errorResponse;

    private ErrorResponse(@Nullable final Response<?> errorResponse) {
        this.errorResponse = errorResponse;
    }

    @NotNull
    public static ErrorResponse of(@Nullable final Response<?> errorResponse) {
        return new ErrorResponse(errorResponse);
    }

    public boolean isResponseNull() {
        return errorResponse == null;
    }

    public boolean hasErrorBody() {
        return !isResponseNull() && errorResponse.errorBody() != null;
    }

    @NotNull
    public String getErrorBody() throws IOException {
        return errorResponse.errorBody().string();
    }
}
