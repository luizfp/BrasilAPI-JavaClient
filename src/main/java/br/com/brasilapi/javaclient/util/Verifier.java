package br.com.brasilapi.javaclient.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created on 2020-11-23
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class Verifier {

    private Verifier() {
        throw new IllegalStateException(Verifier.class.getSimpleName() + " cannot be instantiated!");
    }

    @NotNull
    public static <T> T checkNotNull(@Nullable final T reference) {
        return checkNotNull(reference, null);
    }

    @NotNull
    public static <T> T checkNotNull(@Nullable final T reference, @Nullable final Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }
}
