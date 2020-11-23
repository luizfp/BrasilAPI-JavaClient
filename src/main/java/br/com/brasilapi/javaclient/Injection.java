package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.CepApi;
import br.com.brasilapi.javaclient.cep.error.CepErrorHandler;
import br.com.brasilapi.javaclient.config.MoshiConfig;
import br.com.brasilapi.javaclient.config.OkHttpConfig;
import br.com.brasilapi.javaclient.config.RestClientConfig;
import br.com.brasilapi.javaclient.json.JsonParser;
import br.com.brasilapi.javaclient.network.ServiceLocator;
import br.com.brasilapi.javaclient.network.errorhandler.ResponseErrorHandler;
import br.com.brasilapi.javaclient.network.request.CallExecutor;
import br.com.brasilapi.javaclient.network.request.DefaultResponseHandler;
import br.com.brasilapi.javaclient.network.request.ResponseHandler;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class Injection {

    private Injection() {
        throw new IllegalStateException(Injection.class.getSimpleName() + " cannot be instantiated!");
    }

    @NotNull
    public static CepApi provideCepApi(@NotNull final BrasilApiConfig config) {
        return new CepApi(Injection.provideServiceLocator(config), Injection.provideCallExecutor());
    }

    @NotNull
    public static CallExecutor provideCallExecutor() {
        return new CallExecutor(
                Injection.provideResponseHandler(),
                Injection.provideResponseErrorHandler());
    }

    @NotNull
    public static ResponseHandler provideResponseHandler() {
        return new DefaultResponseHandler();
    }

    @NotNull
    public static ResponseErrorHandler<?> provideResponseErrorHandler() {
        return new CepErrorHandler(Injection.provideJsonParser());
    }

    @NotNull
    public static JsonParser provideJsonParser() {
        return new JsonParser();
    }

    @NotNull
    public static ServiceLocator provideServiceLocator(@NotNull final BrasilApiConfig config) {
        final OkHttpConfig okHttpConfig = Injection.provideOkHttpConfig(config);
        final RestClientConfig restClientConfig = Injection.provideRestClientConfig(okHttpConfig);
        return new ServiceLocator(restClientConfig);
    }

    @NotNull
    public static OkHttpConfig provideOkHttpConfig(@NotNull final BrasilApiConfig config) {
        return new OkHttpConfig(config);
    }

    @NotNull
    public static RestClientConfig provideRestClientConfig(@NotNull final OkHttpConfig config) {
        return new RestClientConfig(config);
    }

    @NotNull
    public static MoshiConverterFactory provideMoshiConverterFactory() {
        return MoshiConverterFactory.create(Injection.provideMoshi());
    }

    @NotNull
    public static Moshi provideMoshi() {
        return MoshiConfig.provideMoshi();
    }
}
