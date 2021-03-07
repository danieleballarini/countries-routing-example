package com.countries.routing.example.controllers;

import com.countries.routing.example.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class ApiController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping()
    public Iterable findAllCountries(
        @RequestParam(name="page", defaultValue="0") int page,
        @RequestParam(name="max", defaultValue="0") int max ) {
        return countryRepository.findAll(page, max);
    }

}
