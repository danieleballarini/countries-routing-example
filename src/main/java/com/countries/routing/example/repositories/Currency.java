package com.countries.routing.example.repositories;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Currency {

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String symbol;

}
