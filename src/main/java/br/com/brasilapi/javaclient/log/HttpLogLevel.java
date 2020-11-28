package br.com.brasilapi.javaclient.log;

import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-25
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 *
 * Based on: https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/src/main/kotlin/okhttp3/logging/HttpLoggingInterceptor.kt
 */
public enum HttpLogLevel {
    /**
     * Logs request and response lines.
     *
     * Example:
     * ```
     * --> POST /greeting http/1.1 (3-byte body)
     *
     * <-- 200 OK (22ms, 6-byte body)
     * ```
     */
    BASIC {
        @NotNull
        @Override
        public HttpLoggingInterceptor.Level toOkHtppLoggingLevel() {
            return HttpLoggingInterceptor.Level.BASIC;
        }
    },

    /**
     * Logs request and response lines and their respective headers.
     *
     * Example:
     * ```
     * --> POST /greeting http/1.1
     * Host: example.com
     * Content-Type: plain/text
     * Content-Length: 3
     * --> END POST
     *
     * <-- 200 OK (22ms)
     * Content-Type: plain/text
     * Content-Length: 6
     * <-- END HTTP
     * ```
     */
    HEADERS {
        @NotNull
        @Override
        public HttpLoggingInterceptor.Level toOkHtppLoggingLevel() {
            return HttpLoggingInterceptor.Level.HEADERS;
        }
    },

    /**
     * Logs request and response lines and their respective headers and bodies (if present).
     *
     * Example:
     * ```
     * --> POST /greeting http/1.1
     * Host: example.com
     * Content-Type: plain/text
     * Content-Length: 3
     *
     * Hi?
     * --> END POST
     *
     * <-- 200 OK (22ms)
     * Content-Type: plain/text
     * Content-Length: 6
     *
     * Hello!
     * <-- END HTTP
     * ```
     */
    BODY {
        @NotNull
        @Override
        public HttpLoggingInterceptor.Level toOkHtppLoggingLevel() {
            return HttpLoggingInterceptor.Level.BODY;
        }
    };

    @NotNull
    public abstract HttpLoggingInterceptor.Level toOkHtppLoggingLevel();
}
