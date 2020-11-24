package br.com.brasilapi.javaclient.cep;

import br.com.brasilapi.javaclient.cep.response.CepResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public interface CepApi {

    @NotNull
    CepResponse findByCep(@NotNull final String cep);
}
