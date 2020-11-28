package br.com.brasilapi.javaclient.log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 2020-11-28
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class AppLogger {
    @NotNull
    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger("Brasil-API");

    private AppLogger() {
        throw new IllegalStateException(AppLogger.class.getSimpleName() + " cannot be instantiated!");
    }

    public static void debug(@Nullable final String message) {
        DEFAULT_LOGGER.debug(message);
    }
}
