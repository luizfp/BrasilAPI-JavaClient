package br.com.brasilapi.javaclient.network.errorhandler;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
@FunctionalInterface
public interface CustomExceptionBuilder<T> {
    @NotNull
    BrasilApiException buildException(final T error);
}
