package br.com.brasilapi.javaclient.network;

import br.com.brasilapi.javaclient.config.RestClientConfig;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created on 2020-11-23
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class ServiceLocator {
    @NotNull
    private static final ConcurrentMap<String, Object> SERVICE_CACHE = new ConcurrentHashMap<>();
    @NotNull
    private final RestClientConfig config;

    public ServiceLocator(@NotNull final RestClientConfig config) {
        this.config = config;
    }

    @NotNull
    public <T> T getService(@NotNull final Class<T> serviceClass) {
        final String canonicalName = serviceClass.getCanonicalName();
        //noinspection unchecked
        return (T) SERVICE_CACHE.computeIfAbsent(canonicalName, key -> getRetrofit().create(serviceClass));
    }

    @NotNull
    private Retrofit getRetrofit() {
        return config.getRetrofit();
    }
}
