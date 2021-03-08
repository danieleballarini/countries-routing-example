package com.countries.routing.example.repositories;

public interface CountryRepository {

    Countries findAll(int page, int max);

    Country updateCountry(String name, Country country) throws Exception;

}
