package br.com.brasilapi.javaclient.config;

import br.com.brasilapi.javaclient.Injection;
import br.com.brasilapi.javaclient.Constants;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class RestClientConfig {
    @NotNull
    private final Retrofit retrofit;

    public RestClientConfig(@NotNull final OkHttpConfig config) {
        this.retrofit = createRestClient(config);
    }

    @NotNull
    public Retrofit getRetrofit() {
        return retrofit;
    }

    @NotNull
    private Retrofit createRestClient(@NotNull final OkHttpConfig config) {
        return new Retrofit.Builder()
                .addConverterFactory(Injection.provideMoshiConverterFactory())
                .baseUrl(Constants.BASE_API_URL)
                .client(config.getOkHttpClient())
                .build();
    }
}