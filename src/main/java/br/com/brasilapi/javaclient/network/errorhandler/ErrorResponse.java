package br.com.brasilapi.javaclient.network.errorhandler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

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

    public boolean hasErrorBody() {
        return !isResponseNull() && errorResponse.errorBody() != null;
    }

    @SuppressWarnings("ConstantConditions")
    @NotNull
    public String getErrorBody() {
        try {
            return errorResponse.errorBody().string();
        } catch (final Throwable ignored) {
            return "";
        }
    }

    private boolean isResponseNull() {
        return errorResponse == null;
    }
}
