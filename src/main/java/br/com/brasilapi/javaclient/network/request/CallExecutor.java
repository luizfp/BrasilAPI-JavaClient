package br.com.brasilapi.javaclient.network.request;

import br.com.brasilapi.javaclient.network.errorhandler.ResponseErrorHandler;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CallExecutor {
    @NotNull
    private final ResponseHandler responseHandler;
    @NotNull
    private final ResponseErrorHandler<?> errorHandler;

    public CallExecutor(@NotNull final ResponseHandler responseHandler,
                        @NotNull final ResponseErrorHandler<?> errorHandler) {
        this.responseHandler = responseHandler;
        this.errorHandler = errorHandler;
    }

    @NotNull
    public <T> T execute(@NotNull final Call<T> call) {
        try {
            final Response<T> response = call.execute();
            return responseHandler.handleResponse(response);
        } catch (final Throwable throwable) {
            throw errorHandler.translateException(throwable);
        }
    }
}
