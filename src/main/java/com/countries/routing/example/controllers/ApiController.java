package com.countries.routing.example.controllers;

import com.countries.routing.example.repositories.Country;
import com.countries.routing.example.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
public class ApiController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping()
    public Iterable<Country> findAllCountries(
        @RequestParam(name="page", defaultValue="0") int page,
        @RequestParam(name="max", defaultValue="0") int max ) {
        return countryRepository.findAll(page, max);
    }

    @PutMapping("/{name}")
    public Country updateCountry(@PathVariable("name") String name, @RequestBody Country country) throws Exception {
        return countryRepository.updateCountry( name, country );
    }

}
