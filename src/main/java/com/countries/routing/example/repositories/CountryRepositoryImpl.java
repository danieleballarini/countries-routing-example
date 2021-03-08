package com.countries.routing.example.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryRepositoryImpl implements CountryRepository {

    @Override
    public Countries findAll(int page, int max) {
        Countries allCountries = invokeGet("https://restcountries.eu/rest/v2/all?fields=name;capital;currencies", Countries.class);
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

    @Override
    public Country updateCountry(String name, Country country) throws Exception {

        Countries countries = invokeGet(
                String.format("https://restcountries.eu/rest/v2/name/%1$s?fullText=true&fields=name;capital;currencies", name),
                Countries.class);
        if (countries == null || countries.isEmpty()) {
            throw new Exception("Unable to update country due to country name does NOT exist");
        }
        Country existingCountry = countries.get(0);

        String capital = country.getCapital();
        if (capital == null || capital.trim().isEmpty()) {
            throw new Exception("Unable to update country due to country capital is NOT valid");
        }
        countries = invokeGet(
            String.format("https://restcountries.eu/rest/v2/capital/%1$s?fields=name;capital;currencies", capital),
            Countries.class);
        if ( countries != null &&
                ( countries.size() > 1 || !countries.get(0).getName().equalsIgnoreCase( existingCountry.getName() ) ) ) {
            throw new Exception("Unable to update country due to country capital is ALREADY assigned");
        }

        existingCountry.setCapital( capital );
        return existingCountry;
    }

    private <T> T invokeGet(String uri, Class<T> clazz) {
        T response = null;
        try {
            response = restTemplate.getForObject(uri, clazz);
        } finally {
            return response;
        }
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
