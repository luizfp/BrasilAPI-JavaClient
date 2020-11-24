package br.com.brasilapi.javaclient.json;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-24
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class UserOneLevelJson {
    @NotNull
    private final String name;
    private final int age;

    public UserOneLevelJson(@NotNull final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
