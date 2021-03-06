package br.com.brasilapi.javaclient.network.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public interface ResponseHandler {

    @NotNull
    <T> T handleResponse(@Nullable final Response<T> response);
}
