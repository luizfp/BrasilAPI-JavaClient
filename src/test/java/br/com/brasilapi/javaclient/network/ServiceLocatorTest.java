package br.com.brasilapi.javaclient.network;

import br.com.brasilapi.javaclient.Injection;
import br.com.brasilapi.javaclient.TestConfigs;
import br.com.brasilapi.javaclient.cep.CepService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceLocatorTest {
    private ServiceLocator serviceLocator;

    @BeforeAll
    public void beforeAll() {
        this.serviceLocator = Injection.provideServiceLocator(TestConfigs.DEFAULT_BRASIL_API_CONFIG);
    }

    @Test
    public void givenAnExistingServiceThenLocatorShouldFind() {
        final CepService service = serviceLocator.getService(CepService.class);
        assertThat(service).isNotNull();
    }

    @Test
    public void givenMultipleServiceGetsThenReturnSameInstance() {
        final CepService service1 = serviceLocator.getService(CepService.class);
        final CepService service2 = serviceLocator.getService(CepService.class);
        final CepService service3 = serviceLocator.getService(CepService.class);
        assertThat(service1).isSameInstanceAs(service2);
        assertThat(service1).isSameInstanceAs(service3);
    }

    @Test
    public void givenANoRealServiceThenLocatorShouldFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> serviceLocator.getService(NotAService.class));
    }

    private static final class NotAService {

    }
}
