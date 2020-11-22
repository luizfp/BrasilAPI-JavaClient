package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.Address;
import br.com.brasilapi.javaclient.cep.CepApi;
import br.com.brasilapi.javaclient.network.CallExecutor;
import br.com.brasilapi.javaclient.network.DefaultResponseHandler;
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
        this.cepApi = new CepApi(new CallExecutor(new DefaultResponseHandler()));
    }

    @NotNull
    public Address findByCep(@NotNull final String cep) {
        return cepApi.findByCep(cep);
    }
}
