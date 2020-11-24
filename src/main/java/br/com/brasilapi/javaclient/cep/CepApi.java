package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.cep.error.CepError;
import br.com.brasilapi.javaclient.cep.response.CepErrorResponse;
import br.com.brasilapi.javaclient.cep.response.CepResponse;
import br.com.brasilapi.javaclient.cep.response.CepSuccessResponse;
import br.com.brasilapi.javaclient.network.ServiceLocator;
import br.com.brasilapi.javaclient.network.request.CallExecutor;
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
    public CepResponse findByCep(@NotNull final String cep) {
        final CepService service = serviceLocator.getService(CepService.class);
        final Call<Address> call = service.findByCep(cep);
        try {
            final Address address = callExecutor.execute(call);
            return new CepSuccessResponse(address);
        } catch (final Throwable throwable) {
            return new CepErrorResponse(CepError.of(throwable));
        }
    }
}
