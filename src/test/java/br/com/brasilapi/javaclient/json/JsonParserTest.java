package br.com.brasilapi.javaclient.json;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.google.common.truth.Truth.*;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public final class JsonParserTest {
    private JsonParser jsonParser;

    @BeforeAll
    public void beforeAll() {
        this.jsonParser = new JsonParser();
    }

    @Test
    public void givenOneLevelJsonShouldConvertToObjectWithSuccess() {
        final String userOneLevelJson = "{\"name\":\"Goku\", \"age\":30}";
        final UserOneLevelJson user = jsonParser.fromJson(userOneLevelJson, UserOneLevelJson.class);
        assertThat(user.getName()).isEqualTo("Goku");
        assertThat(user.getAge()).isEqualTo(30);
    }

    @Test
    public void givenOneLevelJsonShouldConvertToJsonWithSuccess() {
        final UserOneLevelJson user = new UserOneLevelJson("Gohan", 10);
        final String userOneLevelJson = "{\"age\":10,\"name\":\"Gohan\"}";
        final String jsonParsed = jsonParser.toJson(user);
        assertThat(jsonParsed).isEqualTo(userOneLevelJson);
    }
}
