package br.com.brasilapi.javaclient.config;

import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class MoshiUtils {
    private static final Moshi MOSHI;

    static {
        MOSHI = new Moshi.Builder().build();
    }

    @NotNull
    public static Moshi provideMoshi() {
        return MOSHI;
    }
}