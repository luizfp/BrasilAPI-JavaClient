package br.com.brasilapi.javaclient.config;

import br.com.brasilapi.javaclient.BrasilApiConfig;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class OkHttpConfig {
    @NotNull
    private final OkHttpClient okHttpClient;

    public OkHttpConfig(@NotNull final BrasilApiConfig config) {
        this.okHttpClient = createNetworkClient(config);
    }

    @NotNull
    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @NotNull
    private OkHttpClient createNetworkClient(@NotNull final BrasilApiConfig config) {
        return new OkHttpClient.Builder()
                .connectTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS)
                .readTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS)
                .writeTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS)
                .build();
    }
}