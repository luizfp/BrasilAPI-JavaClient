package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.network.CallExecutor;
import br.com.brasilapi.javaclient.network.RestClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepApi {
    @NotNull
    private final CallExecutor callExecutor;

    public CepApi(@NotNull final CallExecutor callExecutor) {
        this.callExecutor = callExecutor;
    }

    @NotNull
    public Address findCepInformation(@NotNull final String cep) {
        final CepService service = RestClient.getService(CepService.class);
        final Call<Address> call = service.findCepInformation(cep);
        return callExecutor.execute(call);
    }
}
