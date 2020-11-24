package br.com.brasilapi.javaclient.cep.response;

import br.com.brasilapi.javaclient.cep.Address;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepSuccessResponse implements CepResponse {
    @NotNull
    private final Address address;

    public CepSuccessResponse(@NotNull final Address address) {
        this.address = address;
    }

    @Override
    public boolean wasSuccessful() {
        return true;
    }

    @NotNull
    public Address getAddress() {
        return address;
    }
}
