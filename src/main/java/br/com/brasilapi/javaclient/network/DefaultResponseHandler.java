package br.com.brasilapi.javaclient.network;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class DefaultResponseHandler implements ResponseHandler {

    @NotNull
    @Override
    public <T> T handleResponse(@Nullable final Response<T> response)  {
        if (response != null) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                // Aqui significa que a resposta recebida é um erro.
                if (response.errorBody() == null) {
                    throw new RuntimeException("Error!");
                }
                throw new IllegalStateException("Error empty!");
            }
        } else {
            throw new RuntimeException("Error!");
        }
    }
}
