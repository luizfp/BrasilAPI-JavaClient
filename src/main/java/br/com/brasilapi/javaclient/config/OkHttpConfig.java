package br.com.brasilapi.javaclient.config;

import br.com.brasilapi.javaclient.BrasilApiConfig;
import br.com.brasilapi.javaclient.log.AppLogger;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class OkHttpConfig {
    @NotNull
    private final BrasilApiConfig config;
    @NotNull
    private final OkHttpClient okHttpClient;

    public OkHttpConfig(@NotNull final BrasilApiConfig config) {
        this.config = config;
        this.okHttpClient = createNetworkClient();
    }

    @NotNull
    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @NotNull
    private OkHttpClient createNetworkClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        addTimeout(builder);
        addLoggingInterceptor(builder);
        return builder.build();
    }

    private void addTimeout(@NotNull final OkHttpClient.Builder builder) {
        builder
                .connectTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS)
                .readTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS)
                .writeTimeout(config.getNetworkTimeout().getSeconds(), TimeUnit.SECONDS);
    }

    private void addLoggingInterceptor(@NotNull final OkHttpClient.Builder builder) {
        if (config.isHttpLogsEnabled()) {
            builder.interceptors().add(createHttpLoggingInterceptor());
        }
    }

    @NotNull
    private HttpLoggingInterceptor createHttpLoggingInterceptor() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(AppLogger::debug);
        httpLoggingInterceptor.setLevel(config.getHttpLogLevel().toOkHtppLoggingLevel());
        return httpLoggingInterceptor;
    }
}