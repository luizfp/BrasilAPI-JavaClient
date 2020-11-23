package br.com.brasilapi.javaclient.network;

import br.com.brasilapi.javaclient.cep.Address;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
@FunctionalInterface
public interface SuccessListener {
    void onSuccess(@NotNull final Address address);
}
