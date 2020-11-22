package br.com.brasilapi.javaclient.cep;

import org.jetbrains.annotations.NotNull;

/**
 * Created on 2020-11-22
 *
 * @author Luiz Felipe (https://github.com/luizfp)
 */
public final class Address {
    @NotNull
    private final String cep;
    @NotNull
    private final String state;
    @NotNull
    private final String city;
    @NotNull
    private final String street;
    @NotNull
    private final String neighborhood;

    public Address(@NotNull final String cep,
                   @NotNull final String state,
                   @NotNull final String city,
                   @NotNull final String street,
                   @NotNull final String neighborhood) {
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.street = street;
        this.neighborhood = neighborhood;
    }

    @NotNull
    public String getCep() {
        return cep;
    }

    @NotNull
    public String getState() {
        return state;
    }

    @NotNull
    public String getCity() {
        return city;
    }

    @NotNull
    public String getStreet() {
        return street;
    }

    @NotNull
    public String getNeighborhood() {
        return neighborhood;
    }
}
