package com.countries.routing.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Countries findAll(int page, int max) {
        Countries allCountries = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", Countries.class);
        if (page == 0 || max == 0) {
            return allCountries;
        }

        Countries pagedCountries = new Countries();

        int fromIndex = (page-1) * max;
        if ( fromIndex > allCountries.size() - 1 ) {
            return pagedCountries;
        }
        int toIndex = ((page-1) * max) + max;
        if ( toIndex > allCountries.size() - 1 ) {
            toIndex = allCountries.size() - 1;
        }

        pagedCountries.addAll( allCountries.subList(fromIndex, toIndex) );
        return pagedCountries;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
