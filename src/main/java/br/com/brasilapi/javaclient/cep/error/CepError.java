package br.com.brasilapi.javaclient.cep.error;

import com.squareup.moshi.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepError {
    @NotNull
    private static final CepError DEFAULT_CEP_ERROR;
    @NotNull
    private final String name;
    @NotNull
    private final String message;
    @NotNull
    private final String type;
    @NotNull
    @Json(name = "errors")
    private final List<CepErrorCause> errorCauses;

    static {
        DEFAULT_CEP_ERROR = new CepError(
                "DefaultCepError",
                "Erro ao realizar a busca por CEP",
                "service_error",
                Collections.emptyList());
    }

    @NotNull
    public static CepError of(@Nullable final Throwable throwable) {
        if (throwable instanceof CepApiException) {
            final CepApiException cepApiException = (CepApiException) throwable;
            return cepApiException.getError();
        } else {
            return DEFAULT_CEP_ERROR;
        }
    }

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

    @Override
    public String toString() {
        return "CepError{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", errorCauses=" + errorCauses +
                '}';
    }
}
