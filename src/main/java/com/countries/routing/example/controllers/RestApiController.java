package com.countries.routing.example.controllers;

import com.countries.routing.example.repositories.Country;
import com.countries.routing.example.repositories.CountryConstraintViolationException;
import com.countries.routing.example.repositories.CountryNotFoundException;
import com.countries.routing.example.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/countries")
public class RestApiController {

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
        try {
            return countryRepository.updateCountry(name, country);
        } catch(CountryNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country Not Found", ex);
        } catch(CountryConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Country Conflict", ex);
        } catch(Exception ex) {
            throw ex;
        }
    }

}
