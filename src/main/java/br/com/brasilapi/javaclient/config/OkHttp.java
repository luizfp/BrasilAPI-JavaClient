package br.com.brasilapi.javaclient.config;

import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class OkHttp {
    private static final long DEFAULT_TIMEOUT_SECONDS = TimeUnit.SECONDS.toSeconds(30);
    @NotNull
    private static final OkHttpClient DEFAULT_CLIENT;

    static {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        DEFAULT_CLIENT = builder.build();
    }

    private OkHttp() {
        throw new IllegalStateException(OkHttp.class.getSimpleName() + " cannot be instantiated!");
    }

    @NotNull
    public static OkHttpClient provideNetworkDefaultClient() {
        return DEFAULT_CLIENT;
    }
}