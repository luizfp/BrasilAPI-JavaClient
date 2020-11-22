package br.com.brasilapi.javaclient.network;

import br.com.brasilapi.javaclient.json.MoshiUtils;
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
public final class RestClient {
    private static final Retrofit RETROFIT;
    @NotNull
    private static final ConcurrentMap<String, Object> SERVICE_CACHE = new ConcurrentHashMap<>();

    static {
        RETROFIT = new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(MoshiUtils.provideMoshi()))
                .baseUrl(NetworkConstants.BASE_API_URL)
                .client(OkHttp.provideNetworkDefaultClient())
                .build();
    }

    private RestClient() {

    }

    @NotNull
    public static <T> T getService(@NotNull final Class<T> serviceClass) {
        final String canonicalName = serviceClass.getCanonicalName();
        //noinspection unchecked
        return (T) SERVICE_CACHE.computeIfAbsent(canonicalName, key -> RETROFIT.create(serviceClass));
    }
}