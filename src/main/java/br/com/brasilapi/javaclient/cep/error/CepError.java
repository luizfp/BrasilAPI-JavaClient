package br.com.brasilapi.javaclient.cep.error;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepError {
    @NotNull
    private final String name;
    @NotNull
    private final String message;
    @NotNull
    private final String type;
    @NotNull
    private final List<CepErrorCause> errorCauses;

    public CepError(@NotNull final String name,
                    @NotNull final String message,
                    @NotNull final String type,
                    @NotNull final List<CepErrorCause> errorCauses) {
        this.name = name;
        this.message = message;
        this.type = type;
        this.errorCauses = errorCauses;
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
    public String getType() {
        return type;
    }

    @NotNull
    public List<CepErrorCause> getErrorCauses() {
        return errorCauses;
    }
}
