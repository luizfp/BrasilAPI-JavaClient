package br.com.brasilapi.javaclient;

import br.com.brasilapi.javaclient.cep.Address;
import br.com.brasilapi.javaclient.cep.CepApi;
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
