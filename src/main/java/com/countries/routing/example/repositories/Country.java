package com.countries.routing.example.repositories;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Country {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String capital;

    @Getter
    @Setter
    private Currencies currencies;
}
