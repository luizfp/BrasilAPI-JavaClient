package br.com.brasilapi.javaclient.json;

import br.com.brasilapi.javaclient.config.MoshiConfig;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class JsonParser {

    public JsonParser() {

    }

    @NotNull
    public String toJson(@NotNull final Object object) {
        return MoshiConfig.provideMoshi().adapter(Object.class).toJson(object);
    }

    @NotNull
    public <T> T fromJson(@NotNull final String json, @NotNull final Class<T> type) {
        final T t;
        try {
            t = MoshiConfig.provideMoshi().adapter(type).fromJson(json);
        } catch (final Throwable throwable) {
            throw new IllegalStateException("Error to parse JSON", throwable);
        }
        if (t == null) {
            throw new IllegalStateException("Generated object from json resulted on null value.");
        }
        return t;
    }
}
