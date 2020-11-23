package br.com.brasilapi.javaclient.cep.error;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepErrorCause {
    @NotNull
    private final String name;
    @NotNull
    private final String message;
    @NotNull
    private final String service;

    public CepErrorCause(@NotNull final String name, @NotNull final String message, @NotNull final String service) {
        this.name = name;
        this.message = message;
        this.service = service;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public String getMessage() {
        return message;
    }

    @NotNull
    public String getService() {
        return service;
    }
}
