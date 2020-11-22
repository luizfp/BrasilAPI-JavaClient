package br.com.brasilapi.javaclient.network;

import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CallExecutor {
    @NotNull
    private final ResponseHandler responseHandler;

    public CallExecutor(@NotNull final ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
    }

    @NotNull
    public <T> T execute(@NotNull final Call<T> call) {
        try {
            return responseHandler.handleResponse(call.execute());
        } catch (final IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
