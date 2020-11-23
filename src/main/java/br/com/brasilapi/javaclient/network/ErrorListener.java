package br.com.brasilapi.javaclient.network;

import br.com.brasilapi.javaclient.cep.Address;
import br.com.brasilapi.javaclient.cep.error.CepError;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
@FunctionalInterface
public interface ErrorListener {
    void onError(@NotNull final CepError error);
}
