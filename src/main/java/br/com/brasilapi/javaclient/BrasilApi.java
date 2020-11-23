package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.Address;
import br.com.brasilapi.javaclient.cep.CepApi;
import br.com.brasilapi.javaclient.cep.error.CepErrorHandler;
import br.com.brasilapi.javaclient.json.JsonParser;
import br.com.brasilapi.javaclient.network.request.CallExecutor;
import br.com.brasilapi.javaclient.network.request.DefaultResponseHandler;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class BrasilApi {
    @NotNull
    private final CepApi cepApi;

    public BrasilApi() {
        this.cepApi = Injection.provideCepApi();
    }

    @NotNull
    public Address findByCep(@NotNull final String cep) {
        return cepApi.findByCep(cep);
    }
}
