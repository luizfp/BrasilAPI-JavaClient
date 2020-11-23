package br.com.brasilapi.javaclient.network.errorhandler;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public class BrasilApiException extends RuntimeException {

    public BrasilApiException(final String message) {
        super(message);
    }
}
