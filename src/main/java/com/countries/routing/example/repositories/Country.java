package com.countries.routing.example.repositories;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
