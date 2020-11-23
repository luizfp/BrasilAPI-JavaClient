package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.network.ServiceLocator;
import br.com.brasilapi.javaclient.network.request.CallExecutor;
import br.com.brasilapi.javaclient.config.RestClientConfig;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class CepApi {
    @NotNull
    private final ServiceLocator serviceLocator;
    @NotNull
    private final CallExecutor callExecutor;

    public CepApi(@NotNull final ServiceLocator serviceLocator,
                  @NotNull final CallExecutor callExecutor) {
        this.serviceLocator = serviceLocator;
        this.callExecutor = callExecutor;
    }

    @NotNull
    public Address findByCep(@NotNull final String cep) {
        final CepService service = serviceLocator.getService(CepService.class);
        final Call<Address> call = service.findByCep(cep);
        return callExecutor.execute(call);
    }
}
