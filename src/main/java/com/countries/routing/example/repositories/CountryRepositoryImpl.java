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
    public Countries findAll() {
        Countries countries = restTemplate.getForObject("https://restcountries.eu/rest/v2/all", Countries.class);
        return countries;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
