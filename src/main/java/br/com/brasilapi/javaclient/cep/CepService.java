package br.com.brasilapi.javaclient.cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public interface CepService {

    @GET("cep/v1/{cep}")
    Call<Address> findByCep(@Path("cep") final String cep);
}
