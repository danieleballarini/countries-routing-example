package com.countries.routing.example.controllers;

import com.countries.routing.example.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class ApiController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping()
    public Iterable findAllCountries() {
        return countryRepository.findAll();
    }

}
