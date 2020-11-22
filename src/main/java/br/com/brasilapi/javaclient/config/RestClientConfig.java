package br.com.brasilapi.javaclient.config;

import br.com.brasilapi.javaclient.network.NetworkConstants;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class RestClientConfig {
    private static final Retrofit RETROFIT;
    @NotNull
    private static final ConcurrentMap<String, Object> SERVICE_CACHE = new ConcurrentHashMap<>();

    static {
        RETROFIT = new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(MoshiConfig.provideMoshi()))
                .baseUrl(NetworkConstants.BASE_API_URL)
                .client(OkHttpConfig.provideNetworkDefaultClient())
                .build();
    }

    private RestClientConfig() {

    }

    @NotNull
    public static <T> T getService(@NotNull final Class<T> serviceClass) {
        final String canonicalName = serviceClass.getCanonicalName();
        //noinspection unchecked
        return (T) SERVICE_CACHE.computeIfAbsent(canonicalName, key -> RETROFIT.create(serviceClass));
    }
}